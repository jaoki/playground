package am.part2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class DomainManager {
	private HashMap<String, String[]> domainCategories;

	public DomainManager(String file){
		domainCategories = new HashMap<String, String[]>();

		// Initialization
		try {
			BufferedReader input =  new BufferedReader(new FileReader(file));
			try {
				String line = null;
				while (( line = input.readLine()) != null){
					String[] parsed = line.split(" ");
					String domain = parsed[0];
					String[] categories = parsed[1].split(",");
					domainCategories.put(domain, categories);
				}
			}finally{
				input.close();
			}		
		}catch (IOException e){
			e.printStackTrace();
		}
		
	}
	public String[] lookupCategories(String domain){
		return domainCategories.get(domain);
	}

}
