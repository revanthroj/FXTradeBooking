package FXTradeBooking;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class TradePrint {
	static Long trNo = 0L;
	private static String username;
	private static String currencyPair;
	private static String transferAmount;
	private static float tranferRate;

	static String CurrencyPair = "USDINR";

	private static Long usdToinr;
	private static String bookStatus;

	static Scanner sc = new Scanner(System.in);
	static TradeData tradeData = new TradeData();
	static ArrayList<TradeData> tradeTable = new ArrayList<>();
	static String inr;

	public void process() {
		float rate = 66.00f;
		tranferRate = rate;
		System.out.println("Enter customer Name");
		username = sc.next();
		currencyPair = currencyCheck();
		System.out.println("Enter amount to transfer");
		transferAmount = inrConverter();
		System.out.println("Do you want to get Rate");
		isgetRate();

	}

	private static String currencyCheck() {
		System.out.println("Enter Currency Pair");
		String currencyPair = sc.next();
		if (CurrencyPair.equalsIgnoreCase(currencyPair)) {
			return currencyPair;
		}
		System.out.println("Only" + CurrencyPair + " is accepted Try Again..");
		return currencyCheck();
	}

	private static void isgetRate() {
		String getRate = sc.next();
		if (("yes").equalsIgnoreCase(getRate)) {
			System.out.println("\nYou are transferring INR " + transferAmount + " to " + username
					+ "(Assuming that rate was " + tranferRate + ")\n");
			book();
		} else if (("no").equalsIgnoreCase(getRate)) {
			book();
		}
	}

	private static String inrConverter() {
		Long transAmountLong = sc.nextLong();
		if (transAmountLong > 0) {
			usdToinr = (long) (transAmountLong * tranferRate);
			NumberFormat formatter = NumberFormat.getCurrencyInstance(new Locale("en", "in"));
			String currency = formatter.format(usdToinr);
			return currency;
		}
		System.out.println("Please Enter Positive Value");
		return inrConverter();
	}

	private static void book() {
		System.out.println("Book/Cancel this trade?");
		bookStatus = sc.next();
		if ("book".equalsIgnoreCase(bookStatus)) {
			tradeData = new TradeData(++trNo, username, currencyPair, transferAmount, tranferRate);
			tradeTable.add(tradeData);
			System.out.println(
					"\nTrade for " + CurrencyPair + " has been booked with rate " + tranferRate + " , The amount of Rs "
							+ transferAmount + " will  be transferred in 2 working days to " + username + "..\n");
		} else {
			System.out.println("Trade is Canceled.");
		}
	}

	public void printData() {
		System.out.println("TradeNo" + "\tCurrencyPair" + "\tCustomerName" + "\tAmount" + "\tRate");
		for (TradeData s : tradeTable) {
			System.out.println(s.getTradeNo() + "\t" + s.getCurrencyPair().toUpperCase() + "\t" + s.getUsername() + "\t"
					+ s.getTransferAmount() + "\t" + s.getTranferRate());
		}
	}
}
