package service;

import java.io.File;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletContext;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.util.JRLoader;


public class RelatorioService implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private static final String FOLDER_RELARIOS = "/relatorios";
	private static final String SUBREPORT_DIR = "SUBREPORT_DIR";
	private String SEPARATOR = File.separator; 
	private String caminhoArquivoRelatorio = null;
	private JRExporter exporter =  null;
	private String caminhoSubReport_Dir = "";
	private File arquivoGerado = null;
	
	public String gerarRelatorio(List<?> listDataBeanCollection, HashMap paramentrosRelatorios
			, String nomeRelatorioJasper, String nomeRelatorioSaida, ServletContext servletContext) throws JRException {
		
		/*Cria lista de collectionDataSource de beans que carraegam os dados para o relatorio*/
		JRBeanCollectionDataSource jrbcds = new JRBeanCollectionDataSource(listDataBeanCollection);
		
		/*Fornece o caminho fisico até a pasta que contem os relatorios .jasper*/
		String caminhoRelatorio = servletContext.getRealPath(FOLDER_RELARIOS);
		
		File file = new File(caminhoRelatorio + SEPARATOR + nomeRelatorioJasper + ".jasper");
		
		if(caminhoRelatorio == null 
				|| (caminhoRelatorio != null && caminhoRelatorio.isEmpty())
				|| !file.exists()) {
			
			caminhoRelatorio = this.getClass().getResource(FOLDER_RELARIOS).getPath();
			SEPARATOR = "";
		}
		
		/*Caminho para imagem*/
		paramentrosRelatorios.put("REPORT_PARAMETER_IMG", caminhoRelatorio);
		
		/*caminho completo ate o relatorio compilado indicado*/
		String caminhoArquivoJasper = caminhoRelatorio + SEPARATOR + nomeRelatorioJasper + ".jasper";
		
		/*Faz o carregamento do relatório*/
		JasperReport relatorioJasper = (JasperReport) JRLoader.loadObjectFromFile(caminhoArquivoJasper);
		
		/*sera paramentros SUBREPORT_DIR com o caminho fisico para subreport*/
		caminhoSubReport_Dir = caminhoRelatorio + SEPARATOR;
		paramentrosRelatorios.put(SUBREPORT_DIR, caminhoSubReport_Dir);
		
		/*Carregar arquivo*/
		JasperPrint impressoraJasper = JasperFillManager.fillReport(relatorioJasper, paramentrosRelatorios, jrbcds);
		
		exporter = new JRPdfExporter();
		
		/*Caminho relatorio exportado*/
		caminhoArquivoRelatorio = caminhoRelatorio + SEPARATOR + nomeRelatorioSaida + ".pdf";
		
		/*Prepara a impressão*/
		exporter.setParameter(JRExporterParameter.JASPER_PRINT, impressoraJasper);
		
		exporter.setParameter(JRExporterParameter.OUTPUT_FILE, arquivoGerado);
		
		/*Executa a exportação*/
		exporter.exportReport();
		
		/*Remove arquivo do servidor após ser realizado download*/
		arquivoGerado.deleteOnExit(); 
	
		
		return caminhoArquivoRelatorio;
	}
	

}
