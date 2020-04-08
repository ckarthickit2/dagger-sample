/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package com.ckarthickit.dagger.sample;


import com.ckarthickit.dagger.sample.di.CommandRouterFactory;
import com.ckarthickit.dagger.sample.di.DaggerCommandRouterFactory;

import java.util.Scanner;

public class CommandLineATM {
    private static final String EXIT_TOKEN = "EXIT";
    public static void main(String[] args) {
        System.out.println("Enter Commands:");
        Scanner scanner = new Scanner(System.in);
        CommandRouter commandRouter  = new CommandRouter();
        while(scanner.hasNextLine()) {
            String nextToken = scanner.nextLine();
            if(EXIT_TOKEN.equalsIgnoreCase(nextToken)) {
                break;
            }
            commandRouter.route(nextToken);
        }
    }
}
