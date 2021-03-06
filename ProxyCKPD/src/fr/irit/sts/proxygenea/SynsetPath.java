package fr.irit.sts.proxygenea;

import java.io.PrintStream;
import java.util.Vector;

import edu.mit.jwi.item.ISynsetID;
import fr.irit.sts.tools.WordNet;

public class SynsetPath {
	private Vector<String> path;
	private ISynsetID syn;
	
	public SynsetPath(ISynsetID syn){
		this.path = WordNet.getHypernyms(syn);
		this.syn=syn;
	}
	
	public boolean comparableTo(SynsetPath p){
		for(String s : this.path){
			if(p.contains(s)) return true;
		}
		return false;
	}

	private boolean contains(String s) {
		for(String cur : this.path){
			if(cur.equals(s)) return true;
		}
		return false;
	}
	
	public Vector<String> reversePath(){
		Vector<String> rev = new Vector<String>();
		for(int i=this.path.size()-1; i>=0; i--) {
			rev.add(this.path.get(i));
		}
		return rev;
	}
	
	public void print(PrintStream stream){
		stream.print(WordNet.getNameForSynset(syn)+": ");
		for(String s : path) stream.print(s+" - ");
		stream.println();
	}
	
	public int size(){
		return path.size();
	}
}
