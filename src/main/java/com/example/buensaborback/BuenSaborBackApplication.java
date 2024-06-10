package com.example.buensaborback;

import com.example.buensaborback.domain.entities.*;
import com.example.buensaborback.repositories.*;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@SpringBootApplication
public class BuenSaborBackApplication {

	private static final Logger logger = LoggerFactory.getLogger(BuenSaborBackApplication.class);

	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private ClienteDomicilioRepository clienteDomicilioRepository;
	@Autowired
	private TelefonoClienteRepository telefonoClienteRepository;
	@Autowired
	private DetallePromocionRepository detallePromocionRepository;
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private PaisRepository paisRepository;

	@Autowired
	private ProvinciaRepository provinciaRepository;

	@Autowired
	private LocalidadRepository localidadRepository;

	@Autowired
	private EmpresaRepository empresaRepository;

	@Autowired
	private SucursalRepository sucursalRepository;

	@Autowired
	private SucursalInsumoRepository sucursalInsumoRepository;

	@Autowired
	private DomicilioRepository domicilioRepository;

	@Autowired
	private UnidadMedidaRepository unidadMedidaRepository;

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private ArticuloInsumoRepository articuloInsumoRepository;

	@Autowired
	private ArticuloManufacturadoRepository articuloManufacturadoRepository;

	@Autowired
	private ImagenArticuloRepository imagenArticuloRepository;
	@Autowired
	private EmpleadoRepository empleadoRepository;
	@Autowired
	private TelefonoEmpleadoRepository telefonoEmpleadoRepository;
	@Autowired
	private PromocionRepository promocionRepository;
	@Autowired
	private PromocionSucursalRepository promocionSucursalRepository;
	@Autowired
	private DetalleManufacturadoRepository detalleManufacturadoRepository;
	@Autowired
	private PedidoRepository pedidoRepository;

	public static void main(String[] args) {
		SpringApplication.run(BuenSaborBackApplication.class, args);
		logger.info("Estoy activo en el main Alberto");
	}

	@Bean
	@Transactional
	CommandLineRunner init(ClienteRepository clienteRepository,
						   ClienteDomicilioRepository clienteDomicilioRepository,
						   DetallePromocionRepository detallePromocionRepository,
						   UsuarioRepository usuarioClienteRepository,
						   PaisRepository paisRepository,
						   ProvinciaRepository provinciaRepository,
						   LocalidadRepository localidadRepository,
						   EmpresaRepository empresaRepository,
						   SucursalRepository sucursalRepository,
						   SucursalInsumoRepository sucursalInsumoRepository,
						   DomicilioRepository domicilioRepository,
						   UnidadMedidaRepository unidadMedidaRepository,
						   CategoriaRepository categoriaRepository,
						   ArticuloInsumoRepository articuloInsumoRepository,
						   ArticuloManufacturadoRepository articuloManufacturadoRepository,
						   ImagenArticuloRepository imagenArticuloRepository,
						   PromocionRepository promocionRepository,
						   PromocionSucursalRepository promocionSucursalRepository,
						   DetalleManufacturadoRepository detalleManufacturadoRepository,
						   PedidoRepository pedidoRepository,
						   EmpleadoRepository empleadoRepository,
						   DetallePedidoRepository detallePedidoRepository,
						   PedidoEstadoRepository pedidoEstadoRepository,
						   TelefonoClienteRepository telefonoClienteRepository,
						   TelefonoEmpleadoRepository telefonoEmpleadoRepository) {
		return args -> {
			logger.info("----------------ESTOY----FUNCIONANDO---------------------");
			// Etapa del dashboard
			// Crear 1 pais
			// Crear 2 provincias para ese pais
			// crear 2 localidades para cada provincia
			Pais pais1 = Pais.builder().nombre("Argentina").build();
			paisRepository.save(pais1);
			//CREACION DE PROVINCIAS
			Provincia provincia1 = Provincia.builder().nombre("Mendoza").pais(pais1).build();
			Provincia provincia2 = Provincia.builder().nombre("Buenos Aires").pais(pais1).build();
			provinciaRepository.save(provincia1);
			provinciaRepository.save(provincia2);

			//CREACION DE LOCALIDADES
			Localidad localidad1 = Localidad.builder().nombre("Lujan de Cuyo").provincia(provincia1).build();
			Localidad localidad2 = Localidad.builder().nombre("Guaymallen").provincia(provincia1).build();
			Localidad localidad3 = Localidad.builder().nombre("Mar del Plata").provincia(provincia2).build();
			Localidad localidad4 = Localidad.builder().nombre("Mar de las Pampas").provincia(provincia2).build();

			localidadRepository.save(localidad1);
			localidadRepository.save(localidad2);
			localidadRepository.save(localidad3);
			localidadRepository.save(localidad4);

			// Crear 1 empresa, 2 sucursales para esa empresa y los Domicilios para esas sucursales

			Empresa empresaCarlos = Empresa.builder().nombre("Lo de Carlos").cuit("30546780L").build();
			empresaRepository.save(empresaCarlos);

			Sucursal sucursalGuaymallen = Sucursal.builder()
					.nombre("En Guaymallen")
					.horarioApertura(LocalTime.of(17, 0))
					.horarioCierre(LocalTime.of(23, 0))
					.esCasaMatriz(true)
					.build();

			Sucursal sucursalMarDelPlata = Sucursal.builder()
					.nombre("En MDQ")
					.horarioApertura(LocalTime.of(16, 0))
					.horarioCierre(LocalTime.of(23, 30))
					.esCasaMatriz(false)
					.build();

			Domicilio domicilioBerutti = Domicilio.builder().cp(5519).calle("Berutti").numero(2684).piso(0).nroDepto("5")
					.localidad(localidad1).build();

			Domicilio domicilioGaboto = Domicilio.builder().cp(7600).calle("Gaboto").numero(3475)
					.localidad(localidad2).build();
			// GRABAMOS DOMICILIOS
			domicilioRepository.save(domicilioBerutti);
			domicilioRepository.save(domicilioGaboto);

			//ASOCIAMOS LOS DOMICILIOS A SUCURSAL
			sucursalGuaymallen.setDomicilio(domicilioBerutti);
			sucursalMarDelPlata.setDomicilio(domicilioGaboto);

			//ASOCIAMOS SUCURSALES A EMPRESA
			empresaCarlos.getSucursales().add(sucursalGuaymallen);
			empresaCarlos.getSucursales().add(sucursalMarDelPlata);

			//ASIGNAMOS EMPRESA A SUCURSALES
			sucursalGuaymallen.setEmpresa(empresaCarlos);
			sucursalMarDelPlata.setEmpresa(empresaCarlos);
			// Grabo las sucursales
			sucursalRepository.save(sucursalGuaymallen);
			sucursalRepository.save(sucursalMarDelPlata);
			// Grabo empresa
			empresaRepository.save(empresaCarlos);

			// Crear Categorías de productos y subCategorías de los mismos
			Categoria categoriaBebidas = Categoria.builder().denominacion("Bebidas").es_insumo(true).build();
			categoriaRepository.save(categoriaBebidas);

			//Categoria categoriaGaseosas = Categoria.builder().denominacion("Gaseosas").categoriaPadre(categoriaBebidas).esInsumo(true).build();
			//categoriaRepository.save(categoriaGaseosas);

			//Categoria categoriaTragos = Categoria.builder().denominacion("Tragos").categoriaPadre(categoriaBebidas).esInsumo(true).build();
			//categoriaRepository.save(categoriaTragos);

			Categoria categoriaPizzas = Categoria.builder().denominacion("Pizzas").es_insumo(false).build();

			Categoria categoriaInsumos = Categoria.builder().denominacion("Insumos").es_insumo(true).build();

			// Grabo la categoría de insumos y de Manufacturados
			categoriaRepository.save(categoriaPizzas);
			categoriaRepository.save(categoriaInsumos);

			logger.info("---------------Crear Unidades de medida--------------------");

			UnidadMedida unidadMedidaGramos = UnidadMedida.builder().denominacion("Gramos").build();
			unidadMedidaRepository.save(unidadMedidaGramos);

			UnidadMedida unidadMedidaLitros = UnidadMedida.builder().denominacion("Litros").build();
			unidadMedidaRepository.save(unidadMedidaLitros);

			UnidadMedida unidadMedidaCentimetros = UnidadMedida.builder().denominacion("Centímetros").build();
			unidadMedidaRepository.save(unidadMedidaCentimetros);

			UnidadMedida unidadMedidaKilos = UnidadMedida.builder().denominacion("Kilos").build();
			unidadMedidaRepository.save(unidadMedidaKilos);

			UnidadMedida unidadMedidaMetros = UnidadMedida.builder().denominacion("Metros").build();
			unidadMedidaRepository.save(unidadMedidaMetros);

			UnidadMedida unidadMedidaCM3 = UnidadMedida.builder().denominacion("Centímetros Cúbicos").build();
			unidadMedidaRepository.save(unidadMedidaCM3);

			UnidadMedida unidadMedidaUnidad = UnidadMedida.builder().denominacion("Unidad").build();
			unidadMedidaRepository.save(unidadMedidaUnidad);

			UnidadMedida unidadMedidaDocena = UnidadMedida.builder().denominacion("Docena").build();
			unidadMedidaRepository.save(unidadMedidaDocena);

			logger.info("---------------asocie unidades de medida a sucursales--------------------");

			// Crear Insumos

			ArticuloInsumo cocaCola = ArticuloInsumo.builder()
					.denominacion("Coca Cola 2.5L")
					.costo(480.0)
					.es_para_elaborar(false)
					.unidadMedida(unidadMedidaLitros)
					.build();
			articuloInsumoRepository.save(cocaCola);

			ArticuloInsumo pepsi = ArticuloInsumo.builder()
					.denominacion("Pepsi 2.5L")
					.costo(450.0)
					.es_para_elaborar(false)
					.unidadMedida(unidadMedidaLitros)
					.build();
			articuloInsumoRepository.save(pepsi);

			ArticuloInsumo harina = ArticuloInsumo.builder()
					.denominacion("Harina 000")
					.costo(90.0)
					.es_para_elaborar(true)
					.categoria(categoriaInsumos)
					.unidadMedida(unidadMedidaKilos)
					.build();
			articuloInsumoRepository.save(harina);

			ArticuloInsumo jamon = ArticuloInsumo.builder()
					.denominacion("Jamon Crudo")
					.costo(900.0)
					.es_para_elaborar(true)
					.categoria(categoriaInsumos)
					.unidadMedida(unidadMedidaKilos)
					.build();
			articuloInsumoRepository.save(jamon);

			ArticuloInsumo morrones = ArticuloInsumo.builder()
					.denominacion("Morrones 1Kg")
					.costo(1100.0)
					.es_para_elaborar(true)
					.categoria(categoriaInsumos)
					.unidadMedida(unidadMedidaKilos)
					.build();
			articuloInsumoRepository.save(morrones);

			ArticuloInsumo cerveza = ArticuloInsumo.builder()
					.denominacion("Cerveza Andes 473ml")
					.costo(600.0)
					.es_para_elaborar(false)
					.unidadMedida(unidadMedidaLitros)
					.build();
			articuloInsumoRepository.save(cerveza);

			ArticuloInsumo fernet = ArticuloInsumo.builder()
					.denominacion("Fernet Branca 750ml")
					.costo(2500.0)
					//.stockActual(300.0)
					//.stockMinimo(50.0)
					//.esInsumo(true)
					.es_para_elaborar(false)
					//.categoria(categoriaTragos)
					.unidadMedida(unidadMedidaLitros)
					.build();
			articuloInsumoRepository.save(fernet);

			ArticuloInsumo menta = ArticuloInsumo.builder()
					.denominacion("Menta con Hielo")
					.costo(2000.0)
					//.stockActual(100.0)
					//.stockMinimo(50.0)
					//.esInsumo(true)
					.es_para_elaborar(true)
					//.categoria(categoriaTragos)
					.unidadMedida(unidadMedidaLitros)
					.build();
			articuloInsumoRepository.save(menta);

			logger.info("---------------Asocio sucursalinsumo y sucursal--------------------");

			// Asigno insumos a las sucursales
			SucursalInsumo sucursalGuaymallenInsumo = SucursalInsumo.builder().sucursal(sucursalGuaymallen).build();
			sucursalGuaymallenInsumo.setInsumo(cocaCola);
			sucursalGuaymallenInsumo.setInsumo(pepsi);
			sucursalGuaymallenInsumo.setInsumo(harina);
			sucursalGuaymallenInsumo.setInsumo(jamon);
			sucursalGuaymallenInsumo.setInsumo(morrones);
			sucursalGuaymallenInsumo.setInsumo(cerveza);
			sucursalGuaymallenInsumo.setInsumo(fernet);
			sucursalGuaymallenInsumo.setInsumo(menta);
			// Grabo insumos de la sucursal
			sucursalInsumoRepository.save(sucursalGuaymallenInsumo);


			logger.info("---------------agregue insumos a sucursales--------------------");

			// Crear productos manufacturados
			ArticuloManufacturado pizzaNapolitana = ArticuloManufacturado.builder()
					.denominacion("Pizza Napolitana")
					//.precioVenta(1200.0)
					.descripcion("pizza rica de queso")
					.preparacion("muzzarela en el horno 10 min")
					.tiempo_estimado_preparacion("20 minutos")
					.build();
			articuloManufacturadoRepository.save(pizzaNapolitana);

			ArticuloManufacturado hamburguesa = ArticuloManufacturado.builder()
					.denominacion("Hamburguesa completa")
					//.precioVenta(1200.0)
					.descripcion("Hamburguesa con queso")
					.preparacion("a la parrilla con condimentos")
					.tiempo_estimado_preparacion("10 minutos")
					.build();
			articuloManufacturadoRepository.save(hamburguesa);

			// Crear detalles de productos manufacturados
			DetalleManufacturado detallePizzaNapolitana1 = DetalleManufacturado.builder()
					.manufacturado(pizzaNapolitana)
					.insumo(harina)
					.build();
			detalleManufacturadoRepository.save(detallePizzaNapolitana1);

			DetalleManufacturado detallePizzaNapolitana2 = DetalleManufacturado.builder()
					.manufacturado(pizzaNapolitana)
					.insumo(morrones)
					.build();
			detalleManufacturadoRepository.save(detallePizzaNapolitana2);

			DetalleManufacturado detalleHamburguesa = DetalleManufacturado.builder()
					.manufacturado(hamburguesa)
					.insumo(jamon)
					.build();
			detalleManufacturadoRepository.save(detalleHamburguesa);

			logger.info("---------------se crearon productos manufacturados y sus detalles--------------------");

			logger.info("----------------------creando clientes----------------------------------");
			Usuario usuario = Usuario.builder()
					.auth0id("auth0id")
					.username("NombreUsuario")
					.email("correo@example.com")
					.rol(Rol.CLIENTE)
					.build();

			usuarioRepository.save(usuario); // Guardar el usuario en la base de datos

			Cliente cliente = Cliente.builder()
					.nombre("Juan")
					.apellido("Perez")
					.fecha_nac(LocalDate.now()) // Supongamos que la fecha de nacimiento es la fecha actual
					.usuario(usuario) // Asignar el usuario correspondiente
					.build();

			clienteRepository.save(cliente); // Guardar el cliente en la base de datos

			Domicilio domicilio = Domicilio.builder()
					.calle("NombreCalle")
					.numero(123)
					.cp(1234)
					.piso(1)
					.nroDepto("A")
					.localidad(localidad1)
					.build();
			domicilioRepository.save(domicilio);

			ClienteDomicilio clienteDomicilio = ClienteDomicilio.builder()
					.cliente(cliente)
					.domicilio(domicilio)
					.build();

			clienteDomicilioRepository.save(clienteDomicilio);

			TelefonoCliente telefonoCliente = TelefonoCliente.builder()
					.numero(444444)
					.cliente(cliente)
					.build();
			telefonoClienteRepository.save(telefonoCliente);
			logger.info("----------------------creando Empleado----------------------------------");

			Usuario usuarioEmpleado1 = Usuario.builder()
					.auth0id("auth0idEmpleado1")
					.username("empleado1")
					.email("empleado1@example.com")
					.rol(Rol.CAJERO) // Asignar el rol de empleado al usuario 1
					.build();
			Usuario usuarioEmpleado2 = Usuario.builder()
					.auth0id("auth0idEmpleado2")
					.username("empleado2")
					.email("empleado2@example.com")
					.rol(Rol.COCINERO)
					.build();
			usuarioRepository.save(usuarioEmpleado1);
			usuarioRepository.save(usuarioEmpleado2);

			Empleado empleado1 = Empleado.builder()
					.nombre("Juan")
					.apellido("Perez")
					.fecha_nac(LocalDate.of(1990, 5, 15))
					.usuario(usuarioEmpleado1)
					.build();

			Empleado empleado2 = Empleado.builder()
					.nombre("María")
					.apellido("García")
					.fecha_nac(LocalDate.of(1985, 8, 20))
					.usuario(usuarioEmpleado2)
					.build();
			empleadoRepository.save(empleado1);
			empleadoRepository.save(empleado2);

			TelefonoEmpleado telefonoEmpleado1 = TelefonoEmpleado.builder()
					.numero(4424242)
					.empleado(empleado1)
					.build();
			telefonoEmpleadoRepository.save(telefonoEmpleado1);
			TelefonoEmpleado telefonoEmpleado2 = TelefonoEmpleado.builder()
					.numero(123123123)
					.empleado(empleado2)
					.build();
			telefonoEmpleadoRepository.save(telefonoEmpleado2);
			logger.info("----------------------creando Promocion----------------------------------");

			Promocion promocionDescuentoBebidas = Promocion.builder()
					.denominacion("Descuento en Bebidas")
					.descripcion_descuento("Descuento del 20% en todas las bebidas")
					.build();
			promocionRepository.save(promocionDescuentoBebidas);

			PromocionSucursal promocionSucursal = PromocionSucursal.builder()
					.habilitado(true)
					.fecha_desde(LocalDate.now())
					.fecha_hasta(LocalDate.now().plusMonths(1))
					.hora_desde("10:00")
					.hora_hasta("22:00")
					.sucursal(sucursalGuaymallen)
					.promocion(promocionDescuentoBebidas)
					.build();
			promocionSucursalRepository.save(promocionSucursal);

			DetallePromocionArticulo detallePromocionArticulo = DetallePromocionArticulo.builder()
					.cantidad(2)
					.articulo(hamburguesa)
					.promocion(promocionDescuentoBebidas)
					.build();
			detallePromocionRepository.save(detallePromocionArticulo);

			logger.info("----------------------creando Pedido----------------------------------");
			Pedido pedido = Pedido.builder()
					.hora_estimada_finalizacion(LocalDateTime.now().plusHours(1))
					.fecha_pedido(LocalDate.now())
					.clienteDomicilio(clienteDomicilio)
					.sucursal(sucursalGuaymallen)
					.empleado(empleado1)
					.formaPago(FormaPago.EFECTIVO)
					.tipoEnvio(TipoEnvio.DELIVERY)
					.build();
			pedidoRepository.save(pedido);

			DetallePedido detalle1 = DetallePedido.builder()
					.cantidad(2)
					.articulo(pizzaNapolitana)
					.pedido(pedido)
					.build();
			detallePedidoRepository.save(detalle1);

			DetallePedido detalle2 = DetallePedido.builder()
					.cantidad(1)
					.articulo(hamburguesa)
					.pedido(pedido)
					.build();
			detallePedidoRepository.save(detalle2);

			PedidoEstado estadoInicial = PedidoEstado.builder()
					.fecha_hora(LocalDateTime.now())
					.pedido(pedido)
					.estado(Estado.PENDIENTE)
					.build();
			pedidoEstadoRepository.save(estadoInicial);
		};
	}
}

