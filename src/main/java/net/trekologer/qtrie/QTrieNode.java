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
import java.util.HashMap;
import java.util.Map;

/**
 * QTrieNode is the internal nodes for a QTrie. It is not likely that nodes
 * would need to be accessed or manipulated directly.
 * @author Andrew D. Bucko {@literal <adb@trekologer.net>}
 *
 */
public class QTrieNode implements Serializable {

    private static final long serialVersionUID = -2373561591763323441L;
    private Map<Character, QTrieNode> nodes;

    /**
     * Create a new QTrieNode
     */
    protected QTrieNode() {
        nodes = new HashMap<Character, QTrieNode>(0);
    }

    /**
     * Get the child node Map for this QTrieNode
     * @return the child node Map
     */
    protected Map<Character, QTrieNode> getNodes() {
        return nodes;
    }

}
