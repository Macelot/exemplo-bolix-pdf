package org.example;
import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.net.URL;
import java.util.*;

import controls.Credentials;
import controls.Datas;
import models.*;
import org.json.JSONObject;

import br.com.gerencianet.gnsdk.Gerencianet;
import br.com.gerencianet.gnsdk.exceptions.GerencianetException;

//https://dev.gerencianet.com.br/docs/bolix-boleto-carne
//https://github.com/gerencianet/gn-api-sdk-java
//https://crunchify.com/in-java-how-to-convert-map-hashmap-to-jsonobject-4-different-ways/
//https://pt.stackoverflow.com/questions/82896/como-posso-incrementar-um-dia-para-uma-data-em-java
//https://stackoverflow.com/questions/7451600/jsonobject-how-to-get-a-value
//https://www.baeldung.com/java-download-file

public class oneStep {
    public static void main(String[] args) {
        Date dataHoje = new Date();
        Datas datas = new Datas();

        String descontoAte = datas.somaDias(dataHoje,6);
        String venceEm = datas.somaDias(dataHoje,15);

        /* *********  Set credentials parameters ******** */
        Credentials credentials = new Credentials();

        //JSONObject = objeto JSON que será utilizado para instanciar a classe Gerencianet, isto é será passado no construtor da classe Gerencianet
        JSONObject options = new JSONObject();
        options.put("client_id", credentials.getClientId());
        options.put("client_secret", credentials.getClientSecret());
        //options.put("partner_token", credentials.getPartnerToken());
        options.put("sandbox", credentials.isSandbox());
        /* ************************************************* */

        //Customer = Cliente
        Customer customer = new Customer("Gorbadoc Oldbuck","94271564656","5144916523");

        //Discount = Desconto
        Discount discount = new Discount("currency",500f);//desconto de R$ 5,00 então R$ 16,00 - 500 = 11,00

        //Configurations = Configurações juros e multa
        Configurations configurations = new Configurations(300f,33f);//juros de 3% e multa de 0,033%

        //Conditional_discount = Desconto condicional
        Conditional_discount conditional_discount = new Conditional_discount("percentage",500f, descontoAte);//5% de desconto se pago até 6 dias 5% de 11,00 = R$ 0,55

        //BankingBillet = Boleto, este objeto será criado com uma data de vencimento e os demais objetos: (Customer,Discount,Configurations,Conditional_discount)
        JSONObject bankingBillet = new JSONObject();
        bankingBillet.put("expire_at", venceEm);
        bankingBillet.put("customer", customer.getCustomerOBJ());
        bankingBillet.put("discount", discount.getDiscountOBJ());
        bankingBillet.put("configurations", configurations.getConfigurationsOBJ());
        bankingBillet.put("conditional_discount", conditional_discount.getConditional_discountOBJ());

        JSONObject payment = new JSONObject();
        payment.put("banking_billet", bankingBillet);

        //Item = Item
        Item item1 = new Item("Item 1",1,600f); //produto de 6 reais
        Item item2 = new Item("Item 2",1,1000f);//produto de 10 reais

        //ArrayList para colocar os dois itens do Bolix
        ArrayList<Item> listaItens = new ArrayList<>();
        listaItens.add(item1);
        listaItens.add(item2);

        //Metadata = Dados com URL de notificações e identificador
        Metadata metadata = new Metadata("https://requestb.in/16rpx6y1","0007");

        //Body = Parte principal do Bolix, é o corpo dele. Este objeto será criado com os objetos: (Payment,Items e Metadata)
        JSONObject body = new JSONObject();
        body.put("payment", payment);
        body.put("items", listaItens);
        body.put("metadata", metadata);//como este não é String, nem ArrayList, na classe Metadata vamos estender a classe JSONObject

        try {
            Gerencianet gn = new Gerencianet(options);
            JSONObject response = gn.call("oneStep", new HashMap<String,String>(), body);
            System.out.println(response);
            JSONObject data = response.getJSONObject("data");
            JSONObject pdf = data.getJSONObject("pdf");
            String nomeArquivo = pdf.getString("charge");
            System.out.println("nome do arquivo "+nomeArquivo);

            //salvar aquivo
            BufferedInputStream in = new BufferedInputStream(new URL(nomeArquivo).openStream());
            FileOutputStream fileOutputStream = new FileOutputStream("bolix.pdf");
            byte dataBuffer[] = new byte[1024];
            int bytesRead;
            while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
                fileOutputStream.write(dataBuffer, 0, bytesRead);
            }

        }catch (GerencianetException e){
            System.out.println(e.getCode());
            System.out.println(e.getError());
            System.out.println(e.getErrorDescription());
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}