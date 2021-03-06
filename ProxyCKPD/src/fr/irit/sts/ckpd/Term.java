package fr.irit.sts.ckpd;

import edu.stanford.nlp.ling.TaggedWord;
import fr.irit.sts.tools.GoogleTFFactory;

public class Term {
	String text;
	String POS;
	double weight;
	
	public Term(TaggedWord taggedWord) {
		this.text=taggedWord.word();
		this.POS=taggedWord.tag();
	}

	public String repr() {
		return text+"/"+POS;
	}
	
	public boolean equals(Object other) {
		Term t = (Term)other;
		return this.equals(t);
	}
	
	public boolean equals(Term other){
		return this.text.equals(other.text); //ignoring POS
	}
	
	public int hashCode(){
		return this.text.hashCode();
	}

	public double getWeight() {
		long nCount=GoogleTFFactory.getFrequency(this.text)+1; //+1 to avoid infinity
		this.weight = 1.0-(Math.log10((double)nCount))/(Math.log10((double)GoogleTFFactory.MAX_FREQ));
		return this.weight;
	}
}
