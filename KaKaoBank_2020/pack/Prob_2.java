package pack;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class Prob_2 {
	@Test
	public void execute() {
		String[] reqs = new String[]{
				"DEPOSIT 3a 10000", "CREATE 3a 300000", "WITHDRAW 3a 150000", "WITHDRAW 3a 150001"
		};

		solution(reqs);
	}

	public class Bank {
		private static final int LIMIT = 0;
		private static final int LEFT = 1;

		private static final int RESP_OK = 200;
		private static final int RESP_ALREADY_EXIST_ACCOUNT = 403;
		private static final int RESP_EXCEED_LIMIT = 403;
		private static final int RESP_NOT_EXIST_ACCOUNT = 404;

		private Map<String, Long[]> accountInfo = new HashMap<>();

		private boolean isExistAccount(String id) {
			return accountInfo.containsKey(id);
		}

		private boolean isAbleToWithdraw(String id, long amount) {
			return accountInfo.get(id)[LIMIT] >= amount;
		}

		public int create(String id, long limit) {
			if(isExistAccount(id)) {
				return RESP_ALREADY_EXIST_ACCOUNT;
			}
			accountInfo.put(id, new Long[]{limit, 0L});
			return RESP_OK;
		}

		public int deposit(String id, long amount) {
			if(!isExistAccount(id)) {
				return RESP_NOT_EXIST_ACCOUNT;
			}

			accountInfo.get(id)[LEFT] += amount;
			return RESP_OK;
		}

		public int withdraw(String id, long amount) {
			if(!isExistAccount(id)) {
				return RESP_NOT_EXIST_ACCOUNT;
			}
			Long[] userAccountInfo = accountInfo.get(id);
			if(userAccountInfo[LIMIT] < amount) {
				return RESP_EXCEED_LIMIT;
			}

			userAccountInfo[LEFT] -= amount;
			userAccountInfo[LIMIT] -= amount;
			return RESP_OK;
		}
	}

	public int[] solution(String[] reqs) {
		int[] resultArr = new int[reqs.length];
		Bank bank = new Bank();
		for(int i = 0; i < reqs.length; i++) {
			String[] operationInfo = reqs[i].split(" ");
			switch (operationInfo[0]) {
				case "CREATE" :
					resultArr[i] = bank.create(operationInfo[1], Long.parseLong(operationInfo[2]));
					break;
				case "WITHDRAW" :
					resultArr[i] = bank.withdraw(operationInfo[1], Long.parseLong(operationInfo[2]));
					break;
				case "DEPOSIT" :
					resultArr[i] = bank.deposit(operationInfo[1], Long.parseLong(operationInfo[2]));
					break;
			}
		}
		return resultArr;
	}

}
