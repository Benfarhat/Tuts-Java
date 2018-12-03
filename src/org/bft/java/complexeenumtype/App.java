package org.bft.java.complexeenumtype;

interface UrlInterface{
	public String url();
}

enum WhoisRIR implements UrlInterface{
    ARIN("whois.arin.net"),
    RIPE("whois.ripe.net"),
    APNIC("whois.apnic.net"),
    AFRINIC("whois.afrinic.net"),
    LACNIC("whois.lacnic.net"),
    JPNIC("whois.nic.ad.jp"),
    KRNIC("whois.nic.or.kr"),
    CNNIC("ipwhois.cnnic.cn"),
    UNKNOWN("");

    private String url;

    WhoisRIR(String url) {
        this.url = url;
    }

    public String url() {
        return url;
    }
}

public class App {
	public static void main(String[] args) {
		System.out.println(WhoisRIR.ARIN.url());
		System.out.println(WhoisRIR.AFRINIC.url());
		

        WhoisRIR rir = WhoisRIR.RIPE;

        switch (rir) {
            case ARIN:
                System.out.println("This is ARIN");
                break;
            case APNIC:
                System.out.println("This is APNIC");
                break;
            case RIPE:
                System.out.println("This is RIPE");
                break;
            default:
                throw new AssertionError("Unknown RIR " + rir);

        }
	}
}