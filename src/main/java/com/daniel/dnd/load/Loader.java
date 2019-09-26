package com.daniel.dnd.load;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import com.daniel.dnd.vo.CharacterInitiative;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

public class Loader {

	public List<CharacterInitiative> loadPlayers() throws IOException {
		Reader reader = Files.newBufferedReader(Paths.get("./players.csv"));
		
		CsvToBean<CharacterInitiative> csvToBean = new CsvToBeanBuilder(reader)
                  .withType(CharacterInitiative.class)
                  .withIgnoreLeadingWhiteSpace(true)
                  .build();
		
		List<CharacterInitiative> players = csvToBean.parse();
		return players;
	}
	
	public List<CharacterInitiative> loadMonster() throws IOException {
		Reader reader = Files.newBufferedReader(Paths.get("./monsters.csv"));
		
		CsvToBean<CharacterInitiative> csvToBean = new CsvToBeanBuilder(reader)
                  .withType(CharacterInitiative.class)
                  .withIgnoreLeadingWhiteSpace(true)
                  .build();
		
		List<CharacterInitiative> monsters = csvToBean.parse();
		return monsters;
	}
}
