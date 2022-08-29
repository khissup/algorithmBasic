package A1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {
	static int		mapSize;
	// 문이 세개 있고, 각각의 문마다 문의 위치에 대한 번호, 문 뒤에 대기하는 사람들, 총 두 개의 정보가 필요하므로, 이를 담아둘 배열을 선언합니다.
	static int[][]	door = new int[3][2];
	static int		ans;
	public static void main(String[] args) throws Exception {
		BufferedReader	br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter	bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder	sb = new StringBuilder();
		StringTokenizer	st;
		int				testCase = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= testCase; tc++)
		{
			ans = 1000000007;
			mapSize = Integer.parseInt(br.readLine());
			for (int i = 0; i < 3; i++)
			{
				st = new StringTokenizer(br.readLine());
				door[i][0] = Integer.parseInt(st.nextToken());
				door[i][1] = Integer.parseInt(st.nextToken());
			}
			// 이 문제는 3개의 문에 대한 순열을 구하고 사람을 입장시켜 점수를 확인하는 문제입니다. Perm함수를 통해 이를 구현합니다.
			// 총 3개의 문에 대해 계산하고, 최대 60명이 들어올 수 있기 때문에 시간복잡도는 O(3! * mapSize * 2)
			perm(0, 0, 0);
			sb.append('#').append(tc).append(' ');
			sb.append(ans).append('\n');
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	
	// visited = 낚시 자리 (최대 60개) 에 대한 방문 처리용 비트마스킹 long 변수 (최대 60개이므로, 64비트 자료형 long 사용)
	// sum = 이동거리의 총 합
	// permVisited = 문의 입장순서에 대한 방문 처리용 비트마스킹 int 변수
	public static void perm(long visited, int sum, int permVisited)
	{
		// 자리를 채우는 과정은 한 번의 순열을 만들 때 현재 방문중인 문 뒤에 대기하고 있는 사람의 수 만큼 반복해야하므로
		// 현재 방문중인 문에서 바뀐 결과만 저장해 둘 비트마스킹 변수가 따로 필요합니다.
		// 따라서 이를 처리하기 위해 비트마스킹을 저장해 둘 temp를 선언합니다.
		long	temp;
		// 마찬가지로, 거리의 총합 역시 현재 방문중인 문에 대해서만 기록을 해두어야 합니다.
		int		sumTemp;
		
		// 만약 모든 문에 대해서 방문이 끝난 상태라면
		if (permVisited == (1 << 3) - 1)
		{
			// 현재까지 계산한 거리의 합계와 ans를 비교하여 더 가까운 거리를 ans에 저장하고 return
			ans = Math.min(ans, sum);
			return ;
		}
		// 순열
		for (int i = 0; i < 3; i++)
		{
			// 만약 해당 문을 방문했다면 continue
			if ((permVisited & (1 << i)) != 0)
				continue ;
			// 문 방문 처리를 합니다. 방문 처리는 사람들을 각각의 자리로 이동시키는 과정입니다.
			// 짝수일 경우 왼쪽 먼저 채울, 오른쪽 먼저 채울지 결정해야 하는데, 모든 케이스에 대해 왼쪽 먼저 채우는 경우와 오른쪽 먼저 채우는 경우를 나눠도 됩니다.
			int		count = door[i][1];
			long	doornum = door[i][0];
			long	j = 0;
			temp = 0;
			sumTemp = 0;
			// 왼쪽 먼저 채우기
			// 사람이 모두 자리에 배치 될 때 까지 (count가 0이 되는 것은 사람을 다 배치했다는 것)
			while (count > 0)
			{
				// 해당 자리가 범위를 벗어나지 않고
				// 해당 자리에 아무도 없다면
				// 왼쪽 먼저 (현재 문 번호 - 거리)
				if (doornum - j > 0 && (visited & ((long)1 << (doornum - j))) == 0 && (temp & ((long)1 << (doornum - j))) == 0)
				{
					// 사람 한명을 배치합니다(count--)
					count--;
					// 해당 위치에 사람이 들어갔다고 임시변수에 or 연산해줍니다.
					temp = temp | ((long)1 << (doornum - j));
					// 거리를 임시변수에 더해줍니다.
					sumTemp += (j + 1);
				}
				// 왼쪽만 두었을 때 count가 0이면 탈출합니다.
				if (count == 0)
					break ;
				// 오른쪽 나중에 (현재 문 번호 + 거리)
				if (doornum + j <= mapSize && (visited & ((long)1 << (doornum + j))) == 0 && (temp & ((long)1 << (doornum + j))) == 0)
				{
					count--;
					temp = temp | ((long)1 << (doornum + j));
					sumTemp += (j + 1);
				}
				// 거리 하나 증가
				j++;
			}
			// 이제 임시변수와 매개변수로 받아왔던 이전 시점의 결과를 합쳐 다음번 순열 함수로 보냅니다.
			perm(visited | temp, sum + sumTemp, permVisited | (1 << i));
			// 아래는 오른쪽 먼저 두는 과정이므로 설명 생략
			count = door[i][1];
			j = 0;
			temp = 0;
			sumTemp = 0;
			while (count > 0)
			{
				if (doornum + j <= mapSize && (visited & ((long)1 << (doornum + j))) == 0 && (temp & ((long)1 << (doornum + j))) == 0)
				{
					count--;
					temp = temp | ((long)1 << (doornum + j));
					sumTemp += (j + 1);
				}
				if (count == 0)
					break ;
				if (doornum - j > 0 && (visited & ((long)1 << (doornum - j))) == 0 && (temp & ((long)1 << (doornum - j))) == 0)
				{
					count--;
					temp = temp | ((long)1 << (doornum - j));
					sumTemp += (j + 1);
				}
				j++;
			}
			perm(visited | temp, sum + sumTemp, permVisited | (1 << i));
		}
	}
}
