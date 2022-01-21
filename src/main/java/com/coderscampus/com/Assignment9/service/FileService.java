package com.coderscampus.com.Assignment9.service;


import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;

import com.coderscampus.com.Assignment9.Recipe;

@Service
public class FileService {

	public List<String> readFile(String filename) throws IOException {
		return Files.readAllLines(Paths.get(filename));
	}
	
	public List<Recipe> readFiles() throws IOException {
		Reader in = new FileReader("recipe.txt");
		List<Recipe> recipes = new ArrayList<>();
		Iterable<CSVRecord> records = CSVFormat.DEFAULT.withEscape('\\').withFirstRecordAsHeader()
				.withIgnoreSurroundingSpaces().parse(in);
		
		
		for(CSVRecord record : records) {
			Recipe foodRecipe = new Recipe();
			 
		foodRecipe.setCookingMinutes(Integer.parseInt(record.get("Cooking Minutes")));
		foodRecipe.setDairyFree(Boolean.parseBoolean(record.get("Dairy Free")));
		foodRecipe.setGlutenFree(Boolean.parseBoolean(record.get("Gluten Free")));
		foodRecipe.setInstructions(record.get("Instructions"));
		foodRecipe.setPreparationMinutes(Double.parseDouble(record.get("Preparation Minutes")));
		foodRecipe.setPricePerServing(Double.parseDouble(record.get("Price Per Serving")));
		foodRecipe.setReadyInMinutes(Integer.parseInt(record.get("Ready In Minutes")));
		foodRecipe.setServings(Integer.parseInt(record.get("Servings")));
		foodRecipe.setSpoonacularScore(Double.parseDouble(record.get("Spoonacular Score")));
		foodRecipe.setTitle(record.get("Title"));
		foodRecipe.setVegan(Boolean.parseBoolean(record.get("Vegan")));
		foodRecipe.setVegetarian(Boolean.parseBoolean(record.get("Vegetarian")));
		
			recipes.add(foodRecipe);
}
		return recipes;
		
	}
}
