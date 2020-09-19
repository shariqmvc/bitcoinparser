package com.shariq.BlockChainParser;



import org.bitcoinj.core.Context;

import com.google.gson.JsonObject;
import com.shariq.BlockChainParser.model.BlockFull;
import com.shariq.BlockChainParser.utlility.FileOperations;
import com.shariq.BlockChainParser.utlility.JsonUtility;

/*
 * A driver class to see the output of the code.
 * Use it to see the json output of the Parsed data.
 * */
public class Handler {

	public static void main(String[] args) {
		//Context.getOrCreate(MainNetParams.get());
		Context.getOrCreate(FileOperations.np);
		JsonObject blocksObj = new JsonObject();
	
		/**
		 * This final output could be written to a file/Database or exposed as Api endpoint
		 * 
	    **/
		//blocksObj = JsonUtility.getJsonStructureOfBlock(BlockParser.getParsedListOfBlocks());
		
		//output in json format
		System.out.println(BlockParser.getParsedListOfBlocks());
		
		
		/* Instructions
		 * Kindly, copy the resultant json output from the console and use any online or offline tool to format the json.
		 * 
		*/
	}
}
