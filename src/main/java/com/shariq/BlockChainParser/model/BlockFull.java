package com.shariq.BlockChainParser.model;

import java.util.ArrayList;
import java.util.List;

import org.bitcoinj.core.Transaction;







/*
 * Model class representing Block structure
*/
public class BlockFull implements IBlockHeader {

	/*
	 * the time that this block was created
	 */
	public long timeStamp;
	
	/*
	 * the current version of the block structure
	 */
	public long version;
	
	/*
	 * a cryptographic hash of all of the transactions included in this block
	 */
	public String merkleRoot;
	/*
	 * he current difficulty that was used to create this block
	 */
	public String difficultyTarget;
	/*
	 * a random value that the creator of a block is allowed to manipulate however they so choose
	 */
	public long Nonce;
	/*
	 * the reference this block's parent block
	 */
	public String prevHash;
	/*
	 * Transactions that occur
	 */
	public List<Transaction> transactions = new ArrayList<Transaction>();

	public long getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}
	public long getVersion() {
		return version;
	}
	public void setVersion(long version) {
		this.version = version;
	}
	public String getMerkleRoot() {
		return merkleRoot;
	}
	public void setMerkleRoot(String merkleRoot) {
		this.merkleRoot = merkleRoot;
	}
	public String getDifficultyTarget() {
		return difficultyTarget;
	}
	public void setDifficultyTarget(String difficultyTarget) {
		this.difficultyTarget = difficultyTarget;
	}
	public long getNonce() {
		return Nonce;
	}
	public void setNonce(long nonce) {
		Nonce = nonce;
	}
	public String getPrevHash() {
		return prevHash;
	}
	public void setPrevHash(String prevHash) {
		this.prevHash = prevHash;
	}
	public List<Transaction> getTransactions() {
		return transactions;
	}
	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}
	
	@Override
	public String toString() {
		return "Block [timeStamp=" + timeStamp + ", version=" + version + ", merkleRoot=" + merkleRoot
				+ ", difficultyTarget=" + difficultyTarget + ", Nonce=" + Nonce + ", prevHash=" + prevHash
				+ ", transactions=" + transactions + "]";
	}
	
}
