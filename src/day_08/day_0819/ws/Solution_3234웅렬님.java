package day_08.day_0819.ws;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_3234웅렬님
{
static int              n;
static int[]            weight;
// 프루닝을 위한 DP 배열.
static int[][]          dpArray = new int[1 << 9][1 << 9];
// 왼쪽 저울에 올라간 추의 무게 >= 남은 추를 오른쪽에 모두 올렸을 때 오른쪽 저울의 무게
// 해당 상황에서는 남은 추를 이용하여 조합의 갯수를 수학으로 계산해도 무방합니다.
// 앞으로 남은 추를 N개라고 하였을 때
// 전체 경우의 수는 이항계수와 순열의 갯수를 곱해가며 모두 더한 값입니다. (2^N * N!) 
static int[]            sum = {1, 2, 8, 48, 384, 3840, 46080, 645120, 10321920};

public static void main(String[] args) throws Exception
{
    BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter  bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuilder   sb = new StringBuilder();
    StringTokenizer st;
    int             testCase = Integer.parseInt(br.readLine());
    int             totalWeight = 0;

    for (int tc = 1; tc <= testCase; tc++)
    {
        sb.append('#').append(tc).append(' ');
        n = Integer.parseInt(br.readLine());
        weight = new int[n];
        totalWeight = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 1 << 9; i++)
            Arrays.fill(dpArray[i], -1);
        // 전체 무게를 미리 구해줍니다. 가지치기를 위해서 나중에 사용하게 됩니다.
        for (int i = 0; i < n; i++)
        {
            weight[i] = Integer.parseInt(st.nextToken());
            totalWeight += weight[i];
        }
        backtracking(0, 0, 0, 0, 0, totalWeight);
        sb.append(dpArray[0][0]).append('\n');
    }
    bw.write(sb.toString());
    bw.flush();
    bw.close();
}

	public static int backtracking(int level, int visited, int left, int lw, int rw, int remain)
	{
	    int ret = 0;
	
	    // 이 문제를 비트필드를 이용한 다이나믹 프로그래밍을 이용하여 풀기로 결정했으므로
	    // 기저조건에 dp배열에 값이 존재하는지를 파악하는 부분을 추가합니다.
	    // 만약 dpArray[현재 추를 올려둔 상황][왼쪽에 추를 올려둔 상황] 을 확인해 보았을 때,
	    // 값이 이미 존재한다면, 이 뒤의 경우의 수는 계산할 필요가 전혀 없습니다.
	    // 따라서 바로 dp배열에 저장된 값을 리턴해주면 됩니다.
	    if (dpArray[visited][left] != -1)
	        return (dpArray[visited][left]);
	    // 만약 오른쪽의 무게가 왼쪽의 무게보다 무겁다면, 이 뒤로는 탐색하지 않습니다.
	    if (rw > lw)
	        return (dpArray[visited][left] = 0);
	    // 만약 모든 추를 다 올려두었다면, 이 경우의 수는 고유한 하나의 값이 됩니다.
	    // 이 두 경우는 dp배열에 저장할 필요가 없지만, 나중에 동일한 위치에 방문했을 때 if의 체크를 줄여 
	    // 어셈블리 단에서 prediction으로 발생하는 오버헤드를 줄이는 역할입니다.
	    if (level == n)
	        return (dpArray[visited][left] = 1);
	    // 만약 왼쪽의 무게가 지금 남아있는 모든 추의 무게, 오른쪽의 무게를 모두 더한 무게보다 무겁다면 
	    // 전처리했던 배열의 값을 호출해서 저장해주고 이를 반환합니다.
	    if (rw + remain <= lw)
	    {
	        dpArray[visited][left] = sum[n - level];
	        return (dpArray[visited][left]);
	    }
	    // 순열을 만드는 코드입니다.
	    // dp배열을 효과적으로 활용하기 위해 ret를 사용하여 
	    // 아래쪽 가지들의 결과를 모두 더해 현재 방문중인 dp배열의 공간에 저장합니다.
	    // 이 때 왼쪽과 오른쪽에 올려두는 경우를 모두 고려해야 한다는 것에 주의합니다.
	    for (int i = 0; i < n; i++)
	    {
	        if ((visited & (1 << i)) == 0)
	        {
	            ret += backtracking(level + 1, (visited | (1 << i)), (left | (1 << i)), lw + weight[i], rw, remain - weight[i]);
	            ret += backtracking(level + 1, (visited | (1 << i)), left, lw, rw + weight[i], remain - weight[i]);
	        }
	    }
	    dpArray[visited][left] = ret;
	    return (ret);
	}
}