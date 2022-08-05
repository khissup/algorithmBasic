import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int result = 0;
		StringTokenizer st;
		Map<Character, Integer> mustContains = new HashMap<>();
		Map<Character, Integer> count = new HashMap<>();
		st = new StringTokenizer(br.readLine(), " ");
		int S = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		char[] str = br.readLine().toCharArray();
		
		st = new StringTokenizer(br.readLine(), " ");
		
		mustContains.put('A', Integer.parseInt(st.nextToken()));
		mustContains.put('C', Integer.parseInt(st.nextToken()));
		mustContains.put('G', Integer.parseInt(st.nextToken()));
		mustContains.put('T', Integer.parseInt(st.nextToken()));
		
		count.put('A', 0);
		count.put('C', 0);
		count.put('G', 0);
		count.put('T', 0);
		
		for(int i = 0; i < P; i++) {
			count.put(str[i], count.get(str[i]) + 1);
		}
		if(count.get('A') >= mustContains.get('A') && 
           count.get('C') >= mustContains.get('C') &&
           count.get('G') >= mustContains.get('G') &&
           count.get('T') >= mustContains.get('T'))
		{
			result++;
		}
		
		for(int i = 1; i < str.length - P + 1; i++) {
			char left = str[i - 1];
			char right = str[i + P - 1];
			count.put(left, count.get(left) - 1);
			count.put(right, count.get(right) + 1);
			if(count.get('A') >= mustContains.get('A') && 
			   count.get('C') >= mustContains.get('C') &&
			   count.get('G') >= mustContains.get('G') &&
			   count.get('T') >= mustContains.get('T'))
			{
				result++;
			}
		}
		
		sb.append(result);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}