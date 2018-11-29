package GIS;

import java.text.ParseException;

public class TEST {

	public static void main(String[] args) throws ParseException {
		
		MyGISElement a = new MyGISElement("40:65:a3:35:4c:c4,Efrat,[WPA-PSK-CCMP+TKIP][WPA2-PSK-CCMP+TKIP][ESS],2017-12-01 10:49:08,1,-75,32.17218268216534,34.81446401702757,13.65040888895076,6,WIFI");
		MyGISElement b = new MyGISElement("08:97:58:32:69:c6,Volvo247,[WPA2-PSK-CCMP][WPS][ESS],2017-12-01 10:49:14,4,-81,32.172209259560766,34.814448298318844,15.376435938028056,8,WIFI");
		MyGISElement c = new MyGISElement("09:97:58:32:69:c6,Volvbbbo247,[WPA2-PSK-CCMP][WPS][ESS],2017-12-01 10:49:14,4,-81,32.172209259560766,34.814448298318844,16.376435938028056,8,WIFI");
		MyGISLayer L = new MyGISLayer();
		MyGISLayer L1 = new MyGISLayer();
		L.add(a);
		L.add(b);
		L.add(c);
		L1.add(c);
		MyGISProject P = new MyGISProject();
		MyGISProject P1 = new MyGISProject();
		P.add(L);
		P1.add(L1);
		System.out.println(P);
		System.out.println(P1);
	
	}

}
