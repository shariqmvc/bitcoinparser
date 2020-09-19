package com.shariq.BlockChainParser.model;

/*
 * Contract for Block header fields
*/
public interface IBlockHeader {

	public long timeStamp = 0;
	public long version = 0;
	public String merkleRoot = "";
	public String difficultyTarget = "";
	public long Nonce = 0;
	public long prevHash = 0;
}
