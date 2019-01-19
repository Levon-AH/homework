package org.models;

import org.enums.CardBrand;
import org.enums.Currency;
import org.enums.IssurBank;

import java.util.Comparator;
import java.util.Date;

public final class Card implements Comparable<Card> {
    private final String number;
    private final CardBrand brand;
    private final Currency currency;
    private final String fullName;
    private final Date expireDate;
    private final IssurBank issurBank;

    public Card(Builder builder){
        number = builder.number;
        brand = builder.brand;
        currency = builder.currency;
        fullName = builder.fullName;
        expireDate = builder.expireDate;
        issurBank = builder.issurBank;
    }

    public String getNumber() {
        return number;
    }

    public CardBrand getBrand() {
        return brand;
    }

    public Currency getCurrency() {
        return currency;
    }

    public String getFullName() {
        return fullName;
    }

    public Date getExpireDate() {
        Date clone = (Date)expireDate.clone();
        return clone;
    }

    public IssurBank getIssurBank() {
        return issurBank;
    }

    @Override
    public String toString() {
        return "Card => {" +
                "number = '" + number + '\'' +
                ", brand = " + brand +
                ", currency = " + currency +
                ", fullName = '" + fullName + '\'' +
                ", expireDate = " + expireDate +
                ", issurBank = " + issurBank +
                '}';
    }

    @Override
    public int compareTo(Card o) {
        return this.number.compareTo(o.getNumber());
    }


    public static class Builder{
        private String number;
        private CardBrand brand;
        private Currency currency;
        private String fullName;
        private Date expireDate;
        private IssurBank issurBank;

        public Builder setNumber(String number) {
            this.number = number;
            return this;
        }

        public Builder setBrand(CardBrand brand) {
            this.brand = brand;
            return this;
        }

        public Builder setCurrency(Currency currency) {
            this.currency = currency;
            return this;
        }

        public Builder setFullName(String fullName) {
            this.fullName = fullName;
            return this;
        }


        public Builder setExpireDate(Date expireDate) {
            this.expireDate = expireDate;
            return this;
        }

        public Builder setIssurBank(IssurBank issurBank) {
            this.issurBank = issurBank;
            return this;
        }

        public Card build(){
            return new Card(this);
        }
    }

}
