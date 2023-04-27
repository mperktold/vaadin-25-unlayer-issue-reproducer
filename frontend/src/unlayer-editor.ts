import { html, LitElement, PropertyValues } from "lit";
import { customElement } from "lit/decorators";

declare var unlayer: any;

@customElement("unlayer-editor")
export class UnlayerEditor extends LitElement {

	render() {
		return html`
			<div style="width:100%;height:100%" id="unlayer">
		`;
	}

	protected createRenderRoot() {
		return this;
	}

	protected firstUpdated(changedProperties: PropertyValues): void {
		super.firstUpdated(changedProperties);
		const editor = unlayer.createEditor({
			id: "unlayer",
			projectId: 1,
			user: 1,
			displayMode: "email"
		});
		editor.addEventListener("design:updated", () => {});
		editor.registerProvider("userUploads", () => {});
		editor.registerCallback("mergeTagRule", () => {});
	}
}
