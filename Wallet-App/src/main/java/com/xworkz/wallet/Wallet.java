package com.xworkz.wallet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
//Anotation Method

@Component
public class Wallet {
	@Value("Yelow")
	private String color;
	@Value("A_ONE")
	private BRAND brand;
	@Autowired
	private Material material;
	@Value("200.00")
	private double price;
	@Autowired
	private Money money;
	@Autowired
	private ATMCard atmCard;
	@Autowired
	private Photo photo;

	public Wallet() {
		System.out.println(this.getClass().getSimpleName() + " Bean is created");

	}

	public Wallet(String color, BRAND brand, Material material, double price, Money money, ATMCard atmCard,
			Photo photo) {
		super();
		this.color = color;
		this.brand = brand;
		this.material = material;
		this.price = price;
		this.money = money;
		this.atmCard = atmCard;
		this.photo = photo;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public BRAND getBrand() {
		return brand;
	}

	public void setBrand(BRAND brand) {
		this.brand = brand;
	}

	public Material getMaterial() {
		return material;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Money getMoney() {
		return money;
	}

	public void setMoney(Money money) {
		this.money = money;
	}

	public ATMCard getAtmCard() {
		return atmCard;
	}

	public void setAtmCard(ATMCard atmCard) {
		this.atmCard = atmCard;
	}

	public Photo getPhoto() {
		return photo;
	}

	public void setPhoto(Photo photo) {
		this.photo = photo;
	}

	@Override
	public String toString() {
		return "Wallet [color=" + color + ", brand=" + brand + ", material=" + material + ", price=" + price
				+ ", money=" + money + ", atmCard=" + atmCard + ", photo=" + photo + "]";
	}

}
