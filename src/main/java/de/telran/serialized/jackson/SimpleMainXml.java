package de.telran.serialized.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class SimpleMainXml {
    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper om = new XmlMapper();
        Person person = new Person("Вася", "Пупкин",
                new Address(7, "Н", "Бассейная"));

        String xml = om.writeValueAsString(person);
        System.out.println(xml);
        //представьте что строка поступила снаружи
        xml = "<Person><firstName>Вася</firstName><lastName>Пупкин</lastName><address><countryCode>7</countryCode><city>Н</city><street>Бассейная</street><number>7</number></address></Person>";
        Person read = om.readValue(xml, Person.class);
        System.out.printf("Read person: %s\n", read);
    }
}
