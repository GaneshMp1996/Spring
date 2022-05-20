package com.xworkz.wallet;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ATMCard {
	@Value("42502659851")
	private long cardNo;
	@Value("433")
	private int cvv;
	@Value("DEBIT")
	private CARDTYPE cardType;
	@Value("Black")
	private String color;

	@Value("14/06/2020")
	private java.util.Date expriyDate;

	public ATMCard() {
		System.out.println(this.getClass().getSimpleName() + " Bean created");

	}

	public long getCardNo() {
		return cardNo;
	}

	public void setCardNo(long cardNo) {
		this.cardNo = cardNo;
	}

	public int getCvv() {
		return cvv;
	}

	public void setCvv(int cvv) {
		this.cvv = cvv;
	}

	public CARDTYPE getCardType() {
		return cardType;
	}

	public void setCardType(CARDTYPE cardType) {
		this.cardType = cardType;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public java.util.Date getExpriyDate() {
		return expriyDate;
	}

	public void setExpriyDate(java.util.Date expriyDate) {
		this.expriyDate = expriyDate;
	}

	@Override
	public String toString() {
		return "ATMCard [cardNo=" + cardNo + ", cvv=" + cvv + ", cardType=" + cardType + ", color=" + color
				+ ", expriyDate=" + expriyDate + "]";
	}

	public ATMCard(long cardNo, int cvv, CARDTYPE cardType, String color, Date expriyDate) {
		super();
		this.cardNo = cardNo;
		this.cvv = cvv;
		this.cardType = cardType;
		this.color = color;
		this.expriyDate = expriyDate;
	}

}
