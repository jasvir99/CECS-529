/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simpleengine;

import java.util.*;

public class NaiveInvertedIndex {

    private HashMap<String, List<Integer>> mIndex;

    public NaiveInvertedIndex() {
        mIndex = new HashMap<>();
    }

    public void addTerm(String term, int documentID) {
        // TO-DO: add the term to the index hashtable. If the table does not have
        // an entry for the term, initialize a new ArrayList<Integer>, add the 
        // docID to the list, and put it into the map. Otherwise add the docID
        // to the list that already exists in the map, but ONLY IF the list does
        // not already contain the docID.
        
        List<Integer> doc = new ArrayList<>();
        if (!mIndex.containsKey(term)) {
            doc.add(documentID);
            mIndex.put(term, doc);
        } else {            
            doc = mIndex.get(term);
            if (!doc.contains(documentID)) {
                doc.add(documentID);
                mIndex.remove(term);
                mIndex.put(term, doc);
            }
        }

    }

    public List<Integer> getPostings(String term) {
        // TO-DO: return the postings list for the given term from the index map.
        if (mIndex.containsKey(term)) {
            return mIndex.get(term);
        } else {
            return null;
        }
    }

    public int getTermCount() {
        // TO-DO: return the number of terms in the index.
        int count = mIndex.size();
        return count;
    }

    public String[] getDictionary() {
        // TO-DO: fill an array of Strings with all the keys from the hashtable.
        // Sort the array and return it.
        String[] list_terms;
        list_terms = mIndex.keySet().toArray(new String[mIndex.size()]);
        Arrays.sort(list_terms);
        return list_terms;
    }
}
