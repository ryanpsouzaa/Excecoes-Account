package application;

import model.entities.Account;
import model.exceptions.DomainException;

import java.util.Locale;
import java.util.Scanner;

public class TestAccount {
    public static void main(String[]args){
        Locale.setDefault(Locale.US);
        Scanner resp = new Scanner(System.in);
        try{
            System.out.println("Enter account data");
            System.out.print("Number: ");
            int numeroConta = resp.nextInt();

            resp.nextLine();

            System.out.print("Holder: ");
            String titularConta = resp.nextLine();

            System.out.print("Initial balance: ");
            double saldoInicial = resp.nextDouble();

            System.out.print("Withdraw limit: ");
            double limiteSaque = resp.nextDouble();

            Account conta = new Account(numeroConta,titularConta,saldoInicial,limiteSaque);


            System.out.print("Enter amount for withdraw: ");
            double valorSaque = resp.nextDouble();
            conta.withdraw(valorSaque);

            System.out.printf("New balance: %.2f\n", conta.getBalance());

        }
        catch(DomainException e){
            System.out.println("Error in withdraw: " + e.getMessage());
        }
    }
}
