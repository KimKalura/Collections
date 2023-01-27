package comparingCollections;

import java.util.Objects;

public class Coin implements Comparable<Coin> {

    private int nominalValue;
    private int mintYear;


    public Coin(int nominalValue, int mintYear) {
        this.nominalValue = nominalValue;
        this.mintYear = mintYear;
    }

    public int getNominalValue() {
        return nominalValue;
    }

    public void setNominalValue(int nominalValue) {
        this.nominalValue = nominalValue;
    }

    public int getMintYear() {
        return mintYear;
    }

    public void setMintYear(int mintYear) {
        this.mintYear = mintYear;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coin coin = (Coin) o;
        return nominalValue == coin.nominalValue;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nominalValue, mintYear);
    }

    @Override
    public int compareTo(Coin anotherCoin) {
        /*if (this.nominalValue == anotherCoin.getNominalValue()) {
            return 0;
        } else if (this.nominalValue < anotherCoin.getNominalValue()) {
            return -1;
        } else {
            return 1;
        }*/
        return Integer.compare(nominalValue, anotherCoin.getNominalValue());
    }


    @Override
    public String toString() {
        return "Coin{" +
                "nominalValue=" + nominalValue +
                ", mintYear=" + mintYear +
                '}';
    }
}
