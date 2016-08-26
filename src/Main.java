import Translator.Translate;

public class Main {
	
	public static void main(String[] args){
		String[] trans = Translate.translate("Hej hur är läget?", "en", "sv");

		for(String s : trans){
			System.out.println( s );
		}

    }

}
