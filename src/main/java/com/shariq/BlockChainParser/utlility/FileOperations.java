package com.shariq.BlockChainParser.utlility;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.bitcoinj.core.NetworkParameters;
import org.bitcoinj.params.MainNetParams;
import org.bitcoinj.utils.BlockFileLoader;

public class FileOperations {

	public static List<File> blockChainFiles = new ArrayList<>();
	public static NetworkParameters np = new MainNetParams();
	
	/*
	 * A method to read the contents of dat file
	 * params String location of file
	 * return BlockFileLoader object for further processing
    */
	public static BlockFileLoader getContentsOfDatFiles(String location) {
		blockChainFiles.add(new File(location));
    	BlockFileLoader bfl = new BlockFileLoader(np, blockChainFiles);
    	return bfl;
	}
	

}
