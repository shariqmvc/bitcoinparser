package com.shariq.BlockChainParser.model;

import java.util.Map;

import org.bitcoinj.core.Block;

/*
 * Contract for parser methods
*/
public interface IParserMethods {

	public void getTransactionData();
	public long getBalance();
	public long getLastTransactionDate();
	public long getAverageBalance();
	public Map<String,Float> computeAverageTransactionsPerMonthPerBlock(Block block);
	public void persistDatatoJsonFile();
}
