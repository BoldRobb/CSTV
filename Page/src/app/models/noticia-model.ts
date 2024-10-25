import { model } from "@angular/core";
import { UsuarioModel } from "./usuario-model";

export class NoticiaModel {
  id!: number;
  usuario!: UsuarioModel;
  imagen!: string;
  html!: string;
  fecha!: Date;
  titulo!: string;
}
