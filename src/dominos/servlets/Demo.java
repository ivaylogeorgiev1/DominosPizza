package dominos.servlets;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import dominos.DAO.IProductDAO;
import dominos.DAO.ProductDAO;

public class Demo {


public static void main(String[] args) throws IOException {
	String filePath = "./WebContent/images/outImage.jpg";
	File outFile = new File(filePath);
	
	if (!outFile.exists()) {
		outFile.createNewFile();
	}
}	
}
