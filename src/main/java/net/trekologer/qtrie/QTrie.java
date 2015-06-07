/*
 * Copyright (c) 2014-2015. Andrew D. Bucko <adb@trekologer.net>
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package net.trekologer.qtrie;

import java.io.Serializable;

/**
 * QTrie is a Java implementation of a trie (http://en.wikipedia.org/wiki/Trie)
 * which can be used to find prefix or exact matches to a search term.
 * @author Andrew D. Bucko {@literal <adb@trekologer.net>}
 *
 */
public class QTrie implements Serializable {

    private static final long serialVersionUID = 6422638758456679330L;
    private QTrieNode root;

    // TODO -- pick a proper terminator character
    private static final Character TERMINATOR = Character.PRIVATE_USE;

    /**
     * Create a new, empty QTrie
     */
    public QTrie() {
        root = new QTrieNode();
    }

    /**
     * Adds supplied pattern to the QTrie
     * @param pattern the pattern to add
     * @exception IllegalArgumentException if pattern is null or empty string
     */
    public void add(String pattern) {
        if((pattern == null) || (pattern.isEmpty())) {
            throw new IllegalArgumentException("Null or empty pattern");
        }
        // get the root node
        QTrieNode n = root;

        // go through the string char by char and add to the trie
        for(Character c : pattern.toCharArray()) {
            if(!n.getNodes().containsKey(c)) {
                n.getNodes().put(c, new QTrieNode());

            }

            n = n.getNodes().get(c);
        }

        // TODO -- can I just put null here or do I need a real instance?
        n.getNodes().put(TERMINATOR, null);
    }

    /**
     * Returns a String representing the best possible match prefix for the
     * provided term from the QTrie. Returns null if no matching prefix found.
     * @param term the search term
     * @return the match or null if no match
     */
    public String searchPrefix(String term) {
        return search(term, false);
    }

    /**
     * Returns a String representing the exact match for the provided term from
     * the QTrie. Returns null if no match found.
     * @param term the search term
     * @return the match or null if no match
     */
    public String searchExact(String term) {
        return search(term, true);
    }

    /**
     * Returns a String representing the exact match for the provided term from
     * the QTrie. Returns null if no exact match found.
     * @param term the search term
     * @param exactMatch search for an exact match (true) or prefix (false)
     * @return the match or null if no match
     */
    private String search(String term, boolean exactMatch) {
        String best = null;
        StringBuilder candidate = new StringBuilder();

        QTrieNode n = root;

        // Transverse the trie node by node, appending to the candidate as we
        // go along. Once we find a terminator, set best to that value
        for(Character c : term.toCharArray()) {
            if(n.getNodes().containsKey(c)) {
                candidate.append(c);
                n = n.getNodes().get(c);
            } else {
                break;
            }

            if(n.getNodes().containsKey(TERMINATOR)) {
                best = candidate.toString();
            }
        }

        if((exactMatch) && (!term.equals(best))) {
            // asked for an exact match but did not find one, return null
            return null;
        }
        return best;
    }

}
