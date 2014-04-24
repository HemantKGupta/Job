package longest.palindromic.substring;

public class LongestPalindromicSubstring {

	public static void main(String[] args) {
		System.out.println(longestPalSubstr("BBABCBCAB".toCharArray()));
		System.out.println(longestPalindromeDP("BBABCBCAB"));
	}
	
	// This function prints the longest palindrome substring of str[].
		// It also returns the length of the longest palindrome
		public static int longestPalSubstr( char[] str ) 
		{
		    int n = str.length; // get length of input string
		 
		    // table[i][j] will be false if substring str[i..j] is not palindrome.
		    // Else table[i][j] will be true
		    boolean[][] table = new boolean [n][n];
		 
		    // All substrings of length 1 are palindromes
		    int maxLength = 1;
		    for( int i = 0; i < n; ++i )
		        table[i][i] = true;
		 
		    // check for sub-string of length 2.
		    int start = 0;
		    for( int i = 0; i < n-1; ++i )
		    {
		        if( str[i] == str[i+1] )
		        {
		            table[i][i+1] = true;
		            start = i;
		            maxLength = 2;
		        }
		    }
		 
		    // Check for lengths greater than 2. k is length of substring
		    for( int k = 3; k <= n; ++k )
		    {
		        // Fix the starting index
		        for( int i = 0; i < n - k + 1 ; ++i )
		        {
		            // Get the ending index of substring from starting index i and length k
		            int j = i + k - 1;
		 
		            // checking for sub-string from ith index to jth index iff str[i+1]
		            // to str[j-1] is a palindrome
		            if( table[i+1][j-1] && str[i] == str[j] )
		            {
		                table[i][j] = true;
		 
		                if( k > maxLength )
		                {
		                    start = i;
		                    maxLength = k;
		                }
		            }
		        }
		    }
		 
		    return maxLength; // return length of LPS
		}
		
		public static String longestPalindromeDP(String s) {
			  int n = s.length();
			  int longestBegin = 0;
			 
			  // table[i][j] will be false if substring str[i..j] is not palindrome.
			  // Else table[i][j] will be true
			  boolean[][] table = new boolean[n][n];
			  
			  // All substrings of length 1 are palindromes
			  int maxLen = 1;
			  for (int i = 0; i < n; i++) {
			    table[i][i] = true;
			  }
			  
			 // check for sub-string of length 2.
			  for (int i = 0; i < n-1; i++) {
			    if (s.charAt(i) == s.charAt(i+1)) {
			      table[i][i+1] = true;
			      longestBegin = i;
			      maxLen = 2;
			    }
			  }
			// check for sub-string of length more than 2.
			  for (int len = 3; len <= n; len++) {
				
				// for each possible substring of length len
			    for (int i = 0; i < n-len+1; i++) {
			      // set end index	
			      int j = i+len-1;
			      
			      if (s.charAt(i) == s.charAt(j) && table[i+1][j-1]) {
			        table[i][j] = true;
			        longestBegin = i;
			        maxLen = len;
			      }
			    }
			  }
			  return s.substring(longestBegin, longestBegin+maxLen);
			}

}
