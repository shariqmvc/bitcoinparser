package com.shariq.BlockChainParser.utlility;

import java.util.List;

import org.bitcoinj.core.Transaction;
import org.bitcoinj.core.TransactionInput;
import org.bitcoinj.core.TransactionOutput;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.shariq.BlockChainParser.model.BlockFull;

public class JsonUtility {
	/*
	 * A json utility method for persisting the output json from the parser.
	 * params List of blocks
	 * return JsonObject of block containing list of blocks and transactions.
    */

	public static JsonObject getJsonStructureOfBlock(List<BlockFull> blocks) {
		JsonArray arrBlocks = new JsonArray();
		JsonObject blockObj = null;
		JsonArray transactions = null;
		JsonObject transactionObj;
        JsonObject transactionInpsObj;
        JsonArray transactionInps;
        JsonObject transactionOpsObj;
        JsonArray transactionOps;
        
        for (BlockFull block : blocks) {
        	blockObj = new JsonObject();
			blockObj.addProperty("prev_hash", block.getPrevHash());
			blockObj.addProperty("time", block.getTimeStamp());
			blockObj.addProperty("version", block.getVersion());
			blockObj.addProperty("merkle_root", block.getMerkleRoot());
			blockObj.addProperty("difficult_target", block.difficultyTarget);
			blockObj.addProperty("nonce", block.getNonce());
			
			//536870912
			transactions = new JsonArray();
			for(Transaction tx : block.getTransactions()) {
				transactionObj = new JsonObject();
				transactionObj.addProperty("appear_in_hashes",String.valueOf(tx.getAppearsInHashes()));
				transactionObj.addProperty("hash",tx.getHashAsString());
				transactionObj.addProperty("lock_time",tx.getLockTime());
				transactionObj.addProperty("message_size",tx.getMessageSize());
				transactionObj.addProperty("optimal_encoding_message_size",tx.getOptimalEncodingMessageSize());
				transactionObj.addProperty("sig_op_count",tx.getSigOpCount());
				transactionObj.addProperty("version",tx.getVersion());
				transactionObj.addProperty("confidence",String.valueOf(tx.getConfidence()));
				
				transactionInps = new JsonArray();
				for(TransactionInput transIp : tx.getInputs()) {
					transactionInpsObj = new JsonObject();
					transactionInpsObj.addProperty("message_size", transIp.getMessageSize());
					transactionInpsObj.addProperty("sequence_number", transIp.getSequenceNumber());
					transactionInpsObj.addProperty("output_point", transIp.getOutpoint().toString());
					transactionInpsObj.addProperty("params", transIp.getParams().toString());
					transactionInpsObj.addProperty("payment_protocol_id", transIp.getParams().getPaymentProtocolId());
					transactionInpsObj.addProperty("parent_transaction_hash", transIp.getParentTransaction().getHashAsString());
					//transIp.getScriptSig();
					//transactionInpsObj.addProperty("script_signature", transIp.getScriptSig().toString());
					transactionInps.add(transactionInpsObj);
					
				 }
				
                transactionObj.add("transaction_inputs",transactionInps);
				
				transactionOps = new JsonArray();
				for(TransactionOutput transOp : tx.getOutputs()) {
					transactionOpsObj = new JsonObject();
					transactionOpsObj.addProperty("message_size", transOp.getMessageSize());
					transactionOpsObj.addProperty("min_non_dust_value", transOp.getMinNonDustValue().toString());
					transactionOpsObj.addProperty("value", transOp.getValue().toString());
					transactionOpsObj.addProperty("", transOp.getParams().toString());
					transactionOpsObj.addProperty("params", transOp.getParentTransaction().toString());
					transactionOpsObj.addProperty("script_public_key", transOp.getScriptPubKey().toString());
					transactionOps.add(transactionOpsObj);
					
				}
				
                transactionObj.add("transaction_outputs", transactionOps);
				
				transactionObj.addProperty("params", tx.getParams().toString());
				transactionObj.addProperty("purpose", tx.getPurpose().toString());
				transactionObj.addProperty("update_time", tx.getUpdateTime().toString());
				transactions.add(transactionObj);
				
			}
			blockObj.add("transactions", transactions);
			arrBlocks.add(blockObj);
        }
        
        JsonObject wrapperObj = new JsonObject();
        wrapperObj.add("blocks", arrBlocks);
     
       
		
		return wrapperObj;
	}
}
