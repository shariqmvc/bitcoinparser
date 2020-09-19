package com.shariq.BlockChainParser;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import org.bitcoinj.core.Block;

import com.shariq.BlockChainParser.model.IParserMethods;

public class ParserOperations implements IParserMethods {

	@Override
	public void getTransactionData() {

	}

	@Override
	public long getBalance() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long getLastTransactionDate() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long getAverageBalance() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Map<String, Float> computeAverageTransactionsPerMonthPerBlock(Block block) {
		// Data structures to keep the statistics.
    	Map<String, Integer> monthlyTxCount = new HashMap<>();
    	Map<String, Integer> monthlyBlockCount = new HashMap<>();
    	
    	  // Extract the month keyword.
	    String month = new SimpleDateFormat("yyyy-MM").format(block.getTime());

	    // Make sure there exists an entry for the extracted month.
	    if (!monthlyBlockCount.containsKey(month)) {
	        monthlyBlockCount.put(month, 0);
	        monthlyTxCount.put(month, 0);
	    }

	    // Update the statistics.
	    monthlyBlockCount.put(month, 1 + monthlyBlockCount.get(month));
	    monthlyTxCount.put(month, block.getTransactions().size() + monthlyTxCount.get(month));
	    
	 // Compute the average number of transactions per block per month.
		Map<String, Float> monthlyAvgTxCountPerBlock = new HashMap<>();
		for (String monthRef : monthlyBlockCount.keySet())
		    monthlyAvgTxCountPerBlock.put(
		            monthRef, (float) monthlyTxCount.get(monthRef) / monthlyBlockCount.get(monthRef));
			
		return monthlyAvgTxCountPerBlock;
	}

	@Override
	public void persistDatatoJsonFile() {
		
		
	}

	

	
	}

	


