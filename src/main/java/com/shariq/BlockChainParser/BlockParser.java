package com.shariq.BlockChainParser;

import java.util.ArrayList;
import java.util.List;

import org.bitcoinj.core.Block;
import org.bitcoinj.utils.BlockFileLoader;

import com.shariq.BlockChainParser.model.BlockFull;
import com.shariq.BlockChainParser.utlility.Constants;
import com.shariq.BlockChainParser.utlility.FileOperations;
/*
 * Implementation of Parser functionality
 **/
public class BlockParser {
	/**
	 * A method used to produce data read from dat file block by block
	 * return List of blocks
	**/

	public static List<BlockFull> getParsedListOfBlocks(){
		BlockFileLoader bfl = FileOperations.getContentsOfDatFiles(Constants.fileLocaion);
		List<BlockFull> blockList = new ArrayList<BlockFull>();
		BlockFull blockData;
	
		
		for (Block block : bfl) {
			blockData = new BlockFull();
			blockData.setTimeStamp(block.getTimeSeconds());
			blockData.setVersion(block.getVersion());
			blockData.setMerkleRoot(String.valueOf(block.getMerkleRoot()));
			blockData.setDifficultyTarget(String.valueOf(block.getDifficultyTarget()));
			blockData.setNonce(block.getNonce());
			blockData.setTransactions(block.getTransactions());
			blockData.setPrevHash(block.getPrevBlockHash().toString());
			blockList.add(blockData);
			
		}
		
		return blockList;
		
	}
}
