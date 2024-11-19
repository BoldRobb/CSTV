
export class NoticiaDTO {
  usuarioId: number;
  imagen: string;
  html: string;
  fecha: Date;
  titulo: string;

  constructor( usuario: number, imagen: string, html: string, fecha: Date, titulo: string) {
    this.usuarioId = usuario;
    this.imagen = imagen;
    this.html = html;
    this.fecha = fecha;
    this.titulo = titulo;
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
