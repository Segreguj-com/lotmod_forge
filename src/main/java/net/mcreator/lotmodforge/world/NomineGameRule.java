package net.mcreator.lotmodforge.world;

import net.minecraftforge.fml.common.ObfuscationReflectionHelper;

import net.minecraft.world.GameRules;

import net.mcreator.lotmodforge.LotmodForgeModElements;

import java.lang.reflect.Method;

@LotmodForgeModElements.ModElement.Tag
public class NomineGameRule extends LotmodForgeModElements.ModElement {
	public static final GameRules.RuleKey<GameRules.BooleanValue> gamerule = GameRules.register("nomine", GameRules.Category.PLAYER, create(false));
	public NomineGameRule(LotmodForgeModElements instance) {
		super(instance, 1);
	}

	public static GameRules.RuleType<GameRules.BooleanValue> create(boolean defaultValue) {
		try {
			Method createGameruleMethod = ObfuscationReflectionHelper.findMethod(GameRules.BooleanValue.class, "func_223568_b", boolean.class);
			createGameruleMethod.setAccessible(true);
			return (GameRules.RuleType<GameRules.BooleanValue>) createGameruleMethod.invoke(null, defaultValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
