package FXTradeBooking;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class TradeBookingProcess {
	static Long tradeNo = 0L;
	private static String username;
	private static String currencyPair;
	private static String transferAmount;
	private static float tranferRate;

	static String CurrencyPair = "USDINR";

	private static Long usdToinr;
	private static String bookingStatus;

	static TradeData tradeData = new TradeData();
	static ArrayList<TradeData> tradeTable = new ArrayList<>();
	static String inr;

	public void initiateBooking() {

		Scanner sc = new Scanner(System.in);
		float rate = 66.00f;
		tranferRate = rate;
		System.out.println("Enter customer Name");
		username = sc.nextLine();
		System.out.println("Enter Currency Pair");
		currencyPair = currencyPairCheck(sc);
		System.out.println("Enter amount to transfer");
		transferAmount = inrConverter(sc);
		System.out.println("Do you want to get Rate");
		isgetRate(sc);

	}

	private static String currencyPairCheck(Scanner sc) {
		String currencyPair = sc.next();
		if (CurrencyPair.equalsIgnoreCase(currencyPair)) {
			return currencyPair;
		}
		System.out.println("Only" + CurrencyPair + " is accepted Try Again..");
		return currencyPairCheck(sc);
	}

	private static void isgetRate(Scanner sc) {
		String rateYesOrNo = sc.next();
		if (("yes").equalsIgnoreCase(rateYesOrNo) || ("y").equalsIgnoreCase(rateYesOrNo)) {
			System.out.println("\nYou are transferring INR " + transferAmount + " to " + username
					+ "(Assuming that rate was " + tranferRate + ")\n");
			bookTrade(sc);
		} else if (("no").equalsIgnoreCase(rateYesOrNo) || ("n").equalsIgnoreCase(rateYesOrNo)) {
			bookTrade(sc);
		} else {
			System.out.println("Please enter valid option ");
			isgetRate(sc);
		}
	}

	private static String inrConverter(Scanner sc) {
		Long transAmountLong = sc.nextLong();
		if (transAmountLong > 0) {
			usdToinr = (long) (transAmountLong * tranferRate);
			NumberFormat formatter = NumberFormat.getCurrencyInstance(new Locale("en", "in"));
			String currency = formatter.format(usdToinr);
			return currency;
		}
		System.out.println("Please Enter valid amount");
		return inrConverter(sc);
	}

	private static void bookTrade(Scanner sc) {
		System.out.println("Book/Cancel this trade?");
		bookingStatus = sc.next();
		if ("book".equalsIgnoreCase(bookingStatus)) {
			tradeData = new TradeData(++tradeNo, username, currencyPair, transferAmount, tranferRate);
			tradeTable.add(tradeData);
			System.out.println(
					"\nTrade for " + CurrencyPair + " has been booked with rate " + tranferRate + ", The amount of Rs "
							+ transferAmount + " will be transferred in 2 working days to " + username + ".\n");
		} else if ("cancel".equalsIgnoreCase(bookingStatus)) {
			System.out.println("Trade is Canceled.");
		} else {
			System.out.println("Please enter valid option ");
			bookTrade(sc);
		}
	}

	public void printTradeTable() {

		if (!tradeTable.isEmpty()) {
			System.out.println("TradeNo" + "\tCurrencyPair" + "\tCustomerName" + "\t\tAmount" + "\tRate");
			for (TradeData s : tradeTable)
				System.out.println(s.getTradeNo() + "\t" + s.getCurrencyPair().toUpperCase() + "\t\t" + s.getUsername()
						+ "\t\t" + s.getTransferAmount() + "\t" + s.getTranferRate());
		} else {
			System.out.println("Table empty...\n");
		}
	}
}
