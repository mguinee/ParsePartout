package parse;

import java.io.File;
import java.io.IOException;

public class Main {
	private static String corpusPath;

    public static void main(String args[]) throws IOException {
		corpusPath = System.getProperty("user.dir") + "\\Corpus_2021";
		String arg = args[0];
    	File directory = new File(corpusPath);
        // Parcourez les fichiers du répertoire
        File[] files = directory.listFiles();
        File dir = new File("./DejaParséAlorsTuVasFaireQuoi");
        dir.mkdir();
        if (files != null) {
            for (File file : files) {
                if (file.isFile() && file.getName().endsWith(".pdf")) {
                	ParsePartout pp = new ParsePartout(file);
                	if(arg=="-t") pp.putInfoTxt(pp.creationFichierSansRename(file));
                	else if(arg=="-x") pp.putInfoXml(pp.creationFichierSansRename(file));
                	else if(arg=="all") {
                		pp.putInfoTxt(pp.creationFichierSansRename(file));
                		pp.putInfoXml(pp.creationFichierSansRename(file));
                	}
                }
            }
        }
        ParsePartout pp = new ParsePartout(new File(corpusPath+"\\Nasr.pdf"));
        

    }
}
