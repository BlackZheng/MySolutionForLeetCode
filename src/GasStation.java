
public class GasStation {
	public int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;
        for(int i = 0; i < len; ){
            int remainingGas = gas[i] - cost[i];
            int curStation = (i + 1) % len;
            int travel = 0;
            while(remainingGas >= 0 && travel < len - 1){//trying to travel around the circuit from the ith gas station
                remainingGas += gas[curStation] - cost[curStation];
                travel ++;
                curStation = (curStation + 1) % len;
            }
            if(travel == len - 1 && remainingGas >= 0)//traveling around the circuit successfully
                return i;
          //The key to prevent from TLE is here. 
          //The stations we passed in last unsuccessful traveling can't be solution, so we just pass them. 
            else if(curStation > i)
                i = curStation;
//          We have tried every station
            else
                i++;
        }
        return -1;
    }
}
