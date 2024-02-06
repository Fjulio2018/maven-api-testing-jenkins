package bdd.automation.api.steps;

import bdd.automation.api.config.SetConfig;
import bdd.automation.api.support.api.ValidacaoApi;
import io.cucumber.java.es.Dado;
import io.cucumber.java.it.Quando;
import io.cucumber.java.pt.Entao;
import io.restassured.path.json.JsonPath;
import org.junit.Assert;

public class BuscarValidarSchema {

    private SetConfig config;

    String status;
    String name;
    JsonPath response;
    private static final String CAMINHO_ESQUEMA = "src/test/java/bdd/automation/api/support/esquema/esquema1.json";

    private void initializeConfig() {
        if (config == null) {
            config = new SetConfig();
            config.setup();
        }
    }

    @Dado("que tenha enviado os requisitos de busca")
    public void que_tenha_enviado_os_requisitos_de_busca(io.cucumber.datatable.DataTable dataTable) {
        System.out.println("Dado");
        name = dataTable.cell(1, 0);
        status = dataTable.cell(1, 1);


        initializeConfig();
    }

    @Quando("Pergormar a busca")
    public void pergormar_a_busca() {
        System.out.println("Quando");
        response = ValidacaoApi.getIndividuoByStatusJ(config, name, status);

        String responseBody = response.prettyPrint();


        config.setLastJsonPath(new JsonPath(responseBody));
    }

    @Entao("valido o status de retorno")
    public void valido_o_status_de_retorno() {
        System.out.println("Entao");
        JsonPath lastJsonPath = config.getLastJsonPath();
        System.out.println("Resultado impresso: " + lastJsonPath.getString("results[0].status"));
        Assert.assertEquals("Dead", lastJsonPath.getString("results[0].status"));
    }

    @Entao("valido o Schema")
    public void valido_o_schema() {
        System.out.println("Entao 2");
        //ValidacaoApi.validarEsquema("esquema1");
        ValidacaoApi.validarEsquema("esqError");

    }
}
