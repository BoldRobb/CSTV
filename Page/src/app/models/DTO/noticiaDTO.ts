import { EquipoModel } from "../equipo-model";

export class NoticiaDTO {
  usuarioId: number;
  imagen: string;
  html: string;
  fecha: Date;
  titulo: string;
  equipos?: EquipoModel[];
  torneos?: EquipoModel[];
  jugadores?: EquipoModel[];
  constructor( usuario: number, imagen: string, html: string, fecha: Date, titulo: string, equipos?: EquipoModel[], torneos?: EquipoModel[], jugadores?: EquipoModel[]) {
    this.usuarioId = usuario;
    this.imagen = imagen;
    this.html = html;
    this.fecha = fecha;
    this.titulo = titulo;
    this.equipos = equipos;
    this.torneos = torneos;
    this.jugadores = jugadores;
  }



  getImagen(): string {
    return this.imagen;
  }

  setImagen(imagen: string): void {
    this.imagen = imagen;
  }

  getHtml(): string {
    return this.html;
  }

  setHtml(html: string): void {
    this.html = html;
  }

  getFecha(): Date {
    return this.fecha;
  }

  setFecha(fecha: Date): void {
    this.fecha = fecha;
  }

  getTitulo(): string {
    return this.titulo;
  }

  setTitulo(titulo: string): void {
    this.titulo = titulo;
  }
}
