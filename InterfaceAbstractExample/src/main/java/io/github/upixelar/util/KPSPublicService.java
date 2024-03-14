package io.github.upixelar.util;

import io.github.upixelar.model.Customer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class KPSPublicService {
    public boolean validate(String tckno, String firstName, String lastName, int birthYear){
        try{

            HttpURLConnection connection = createSoapConnection("https://tckimlik.nvi.gov.tr/Service/KPSPublic.asmx");
            String response = postRequest(connection, createKPSSoapRequest(tckno, firstName,lastName,birthYear));

            return response.contains("<TCKimlikNoDogrulaResult>true</TCKimlikNoDogrulaResult>");

        }catch(Exception e){
            throw new RuntimeException("URL ERROR");
        }
    }

    private HttpURLConnection createSoapConnection(String url) throws IOException{
        URL endpoint = new URL(url);
        HttpURLConnection connection = (HttpURLConnection) endpoint.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/soap+xml; charset=utf-8");
        connection.setDoOutput(true);

        return connection;
    }

    private String createKPSSoapRequest(String tckno, String firstName, String lastName, int birthYear){
        return String.format(
                "<?xml version=\"1.0\" encoding=\"utf-8\"?>"
                + "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">"
                + "<soap12:Body>"
                + "<TCKimlikNoDogrula xmlns=\"http://tckimlik.nvi.gov.tr/WS\">"
                + "<TCKimlikNo>%s</TCKimlikNo>"
                + "<Ad>%s</Ad>"
                + "<Soyad>%s</Soyad>"
                + "<DogumYili>%d</DogumYili>"
                + "</TCKimlikNoDogrula>"
                + "</soap12:Body>"
                + "</soap12:Envelope>",
                tckno, firstName, lastName, birthYear);
    }

    private String postRequest(HttpURLConnection connection, String request) throws IOException {
        OutputStream outputStream = connection.getOutputStream();
        outputStream.write(request.getBytes());
        outputStream.flush();

        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String line;
        StringBuilder response = new StringBuilder();

        while ((line = reader.readLine()) != null) {
            response.append(line);
        }

        return response.toString();
    }
}
