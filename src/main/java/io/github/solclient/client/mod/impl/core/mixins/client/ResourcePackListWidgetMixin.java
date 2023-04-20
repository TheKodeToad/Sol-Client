/*
 * Sol Client - an open source Minecraft client
 * Copyright (C) 2021-2023  TheKodeToad and Contributors
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package io.github.solclient.client.mod.impl.core.mixins.client;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.resourcepack.ResourcePackListWidget;
import net.minecraft.client.gui.widget.ListWidget;

@Mixin(ResourcePackListWidget.class)
public abstract class ResourcePackListWidgetMixin extends ListWidget {

	public ResourcePackListWidgetMixin(MinecraftClient client, int width, int height, int top, int bottom,
			int entryHeight) {
		super(client, width, height, top, bottom, entryHeight);
	}

	@Inject(method = "<init>", at = @At("RETURN"))
	public void overrideTop(CallbackInfo callback) {
		yStart += 16;
		height -= 16;
		setHeader(false, 0);
	}

}
