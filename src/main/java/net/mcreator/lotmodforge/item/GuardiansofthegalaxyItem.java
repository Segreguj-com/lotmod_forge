
package net.mcreator.lotmodforge.item;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.ResourceLocation;
import net.minecraft.item.Rarity;
import net.minecraft.item.MusicDiscItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.client.util.ITooltipFlag;

import net.mcreator.lotmodforge.itemgroup.TechnologyItemGroup;
import net.mcreator.lotmodforge.LotmodForgeModElements;

import java.util.List;

@LotmodForgeModElements.ModElement.Tag
public class GuardiansofthegalaxyItem extends LotmodForgeModElements.ModElement {
	@ObjectHolder("lotmod_forge:guardiansofthegalaxy")
	public static final Item block = null;
	public GuardiansofthegalaxyItem(LotmodForgeModElements instance) {
		super(instance, 3);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new MusicDiscItemCustom());
	}
	public static class MusicDiscItemCustom extends MusicDiscItem {
		public MusicDiscItemCustom() {
			super(0, LotmodForgeModElements.sounds.get(new ResourceLocation("lotmod_forge:guardiansgalaxy")),
					new Item.Properties().group(TechnologyItemGroup.tab).maxStackSize(1).rarity(Rarity.RARE));
			setRegistryName("guardiansofthegalaxy");
		}

		@Override
		@OnlyIn(Dist.CLIENT)
		public boolean hasEffect(ItemStack itemstack) {
			return true;
		}

		@Override
		public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
			super.addInformation(itemstack, world, list, flag);
			list.add(new StringTextComponent("Guardians of the galaxy"));
		}
	}
}
