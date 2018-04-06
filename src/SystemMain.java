import Util.Date;
import Util.Hour;

import java.util.*;
import System.*;
//import static System.Empregado.changeData;
//import static System.Salario.*;

public class SystemMain {

    public static void main(String[] args){
        ArrayList<System.Empregado> empregados = new ArrayList<>();
        ArrayList<System.Empregado> previous = new ArrayList<>();
        int escolha = 1, ident = 1, identSind = 1;
        Scanner input = new Scanner(System.in);
        while(escolha != 0) {
            System.out.println("1. Adicionar empregado.\n2. Remover empregado.\n3. Lançar um cartão de ponto.\n" +
                    "4. Larçar um resultado de venda.\n5. Lançar uma taxa de serviço.\n6. Alterar informações de empregado.\n" +
                    "7. Rodar folha de pagamento para hoje.\n8. Agenda de pagamento.\n9. Criar nova agenda de pagamento.\n" +
                    "10. Desfazer/Refazer\n0. Sair");
            escolha = input.nextInt();
            String lixo = input.nextLine();
            if(escolha == 1){
                previous = empregados;
                System.out.println("O empregado está associado ao sindicado ?");
                String aux = input.nextLine();
                if(aux.equals("Sim")){
                    Empregado.addE(empregados, 0, identSind);
                    identSind++;
                } else {
                    Empregado.addE(empregados, ident, 0);
                    ident++;
                }
            } else if(escolha == 2){
                previous = empregados;
                Empregado.removeE(empregados);
            } else if(escolha == 3){
                previous = empregados;
                CartaoPonto.baterP(empregados);
            } else if(escolha == 4){
                previous = empregados;
                Salario.resulVenda(empregados);
            } else if(escolha == 5){
                previous = empregados;
                Salario.taxaServ(empregados);
            } else if(escolha == 6){
                previous = empregados;
                Empregado.changeData(empregados, ident, identSind);
            } else if(escolha == 7){
                previous = empregados;
                Salario.payment(empregados);
            } else if(escolha == 8){
                Salario.agenda(empregados);
            } else if(escolha == 9){
                System.out.println("Erro, opção indisponível no momento!");
            } else if(escolha == 10){
                empregados = previous;
                System.out.println("Ação desfeita!");
            }
        }
    }
}
