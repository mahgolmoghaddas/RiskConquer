package com.risk.model;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import com.risk.entity.Territory;

public class DiceModelTest {

	/**
	 * The @diceModel .
	 */
	static DiceModel diceModel;
	/**
	 * The @attackingTerritory .
	 */
	static Territory attackingTerritory;

	/**
	 * The @defendingTerritory .
	 */
	static Territory defendingTerritory;

	/**
	 * The @attackerDiceValues .
	 */
	static List<Integer> attackerDiceValues;

	/**
	 * The @defenderDiceValues .
	 */
	static List<Integer> defenderDiceValues;

	/**
	 * This method is invoked at the start of the test class.
	 */
	static int defenderDiceValue, attackerDiceValue;
	
	@BeforeClass
	public static void beforeClass() {
		attackingTerritory = new Territory();
		defendingTerritory = new Territory();	
		attackerDiceValues = new ArrayList<Integer>();
		defenderDiceValues = new ArrayList<Integer>();
		diceModel = new DiceModel(attackingTerritory, defendingTerritory);
	}	

	/**
	 * This method is invoked at the start of all the test methods.
	 */
	@Before
	public void beforeTest() {
		attackingTerritory.setArmies(3);
		defendingTerritory.setArmies(3);
		attackerDiceValues.add(diceModel.randomNumber());
		defenderDiceValues.add(diceModel.randomNumber());
		attackerDiceValue = attackerDiceValues.get(0);
		defenderDiceValue = defenderDiceValues.get(0);
	}

	@Test
	public void moreDiceRollAvailable() {
		assertTrue(attackingTerritory.getArmies() > 2);
		assertTrue(defendingTerritory.getArmies() > 0);
		assertEquals(true, diceModel.moreDiceRollAvailable());
	}
	
	@Test
	public void moreDiceRollAvailablePassWrongValues() {
		attackingTerritory.setArmies(1);
		defendingTerritory.setArmies(0);
		assertFalse(attackingTerritory.getArmies() > 2);
		assertFalse(defendingTerritory.getArmies() > 0);
		assertEquals(false, diceModel.moreDiceRollAvailable());
	}

	@Test
	public void updateArmiesAfterAttack() {
		List<String> playResult = new ArrayList<>();
		diceModel.updateArmiesAfterAttack(defenderDiceValue, attackerDiceValue, playResult);
		assertTrue(playResult.get(0).equals("Defender lost 1 army") ||
				playResult.get(0).equals("Attacker lost 1 army."));
	}
	
	@Test
	public void getPlayResultAfterDiceThrown() {
		List<String> playResult = new ArrayList<>();
		diceModel.updateArmiesAfterAttack(defenderDiceValue, attackerDiceValue, playResult);
		System.out.println(diceModel.getPlayResultAfterDiceThrown());
		//assertTrue(diceModel.getPlayResultAfterDiceThrown().size() > 0);	
	}
}
