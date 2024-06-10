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
	private SubCategoriaRepository subCategoriaRepository;

	@Autowired
	private ArticuloInsumoRepository articuloInsumoRepository;

	@Autowired
	private ArticuloManufacturadoRepository articuloManufacturadoRepository;

	@Autowired
	private ImagenArticuloRepository imagenArticuloRepository;
	@Autowired
	private EmpleadoRepository empleadoRepository;
	@Autowired
	private HistorialEmpleadoSucursalRepository historialEmpleadoSucursalRepository;
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
	@Autowired
	private RolRepository rolRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private TipoEnvioRepository tipoEnvioRepository;
	@Autowired
	private FormaPagoRepository formaPagoRepository;
	@Autowired
	private StockInsumoRepository stockInsumoRepository;
	@Autowired
	private SucursalManufacturadoRepository sucursalManufacturadoRepository;

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
						   SubCategoriaRepository subCategoriaRepository,
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
						   TelefonoEmpleadoRepository telefonoEmpleadoRepository,
						   RolRepository rolRepository,
						   EstadoRepository estadoRepository,
						   TipoEnvioRepository tipoEnvioRepository,
						   FormaPagoRepository formaPagoRepository,
						   StockInsumoRepository stockInsumoRepository,
						   SucursalManufacturadoRepository sucursalManufacturadoRepository,
						   HistorialEmpleadoSucursalRepository historialEmpleadoSucursalRepository) {
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

			Categoria categoriaGaseosas = Categoria.builder().denominacion("Gaseosas").es_insumo(true).build();
			categoriaRepository.save(categoriaGaseosas);

			Categoria categoriaTragos = Categoria.builder().denominacion("Tragos").es_insumo(true).build();
			categoriaRepository.save(categoriaTragos);

			SubCategoria subCategoria1 = SubCategoria.builder()
					.categoriaPadre(categoriaBebidas)
					.categoriaHija(categoriaGaseosas)
					.build();
			SubCategoria subCategoria2 = SubCategoria.builder()
					.categoriaPadre(categoriaBebidas)
					.categoriaHija(categoriaTragos)
					.build();
			subCategoriaRepository.save(subCategoria1);
			subCategoriaRepository.save(subCategoria2);

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
					.es_para_elaborar(false)
					.unidadMedida(unidadMedidaLitros)
					.categoria(categoriaGaseosas)
					.build();
			articuloInsumoRepository.save(cocaCola);

			ArticuloInsumo pepsi = ArticuloInsumo.builder()
					.denominacion("Pepsi 2.5L")
					.es_para_elaborar(false)
					.unidadMedida(unidadMedidaLitros)
					.categoria(categoriaGaseosas)
					.build();
			articuloInsumoRepository.save(pepsi);

			ArticuloInsumo harina = ArticuloInsumo.builder()
					.codigo("I123")
					.denominacion("Harina 000")
					.es_para_elaborar(true)
					.categoria(categoriaInsumos)
					.unidadMedida(unidadMedidaKilos)
					.build();
			articuloInsumoRepository.save(harina);

			ArticuloInsumo jamon = ArticuloInsumo.builder()
					.codigo("I124")
					.denominacion("Jamon Crudo")
					.es_para_elaborar(true)
					.categoria(categoriaInsumos)
					.unidadMedida(unidadMedidaKilos)
					.build();
			articuloInsumoRepository.save(jamon);

			ArticuloInsumo morrones = ArticuloInsumo.builder()
					.codigo("I125")
					.denominacion("Morrones 1Kg")
					.es_para_elaborar(true)
					.categoria(categoriaInsumos)
					.unidadMedida(unidadMedidaKilos)
					.build();
			articuloInsumoRepository.save(morrones);

			ArticuloInsumo cerveza = ArticuloInsumo.builder()
					.codigo("I126")
					.denominacion("Cerveza Andes 473ml")
					.es_para_elaborar(false)
					.unidadMedida(unidadMedidaLitros)
					.categoria(categoriaTragos)
					.build();
			articuloInsumoRepository.save(cerveza);

			ArticuloInsumo fernet = ArticuloInsumo.builder()
					.codigo("I127")
					.denominacion("Fernet Branca 750ml")
					.es_para_elaborar(false)
					.unidadMedida(unidadMedidaLitros)
					.categoria(categoriaTragos)
					.build();
			articuloInsumoRepository.save(fernet);

			ArticuloInsumo menta = ArticuloInsumo.builder()
					.denominacion("Menta con Hielo")
					.es_para_elaborar(true)
					.categoria(categoriaInsumos)
					.unidadMedida(unidadMedidaLitros)
					.build();
			articuloInsumoRepository.save(menta);

			logger.info("---------------Asocio sucursalinsumo y sucursal--------------------");

			// Asigno insumos a las sucursales
			SucursalInsumo sucursalGuaymallenInsumoCoca = SucursalInsumo.builder()
					.sucursal(sucursalGuaymallen)
					.stock_minimo(10)
					.stock_maximo(100)
					.build();
			sucursalGuaymallenInsumoCoca.setInsumo(cocaCola);
			sucursalInsumoRepository.save(sucursalGuaymallenInsumoCoca);

			SucursalInsumo sucursalGuaymallenInsumoPepsi = SucursalInsumo.builder()
					.stock_minimo(5)
					.stock_maximo(50)
					.sucursal(sucursalGuaymallen)
					.build();
			sucursalGuaymallenInsumoPepsi.setInsumo(pepsi);
			sucursalInsumoRepository.save(sucursalGuaymallenInsumoPepsi);

			SucursalInsumo sucursalGuaymallenInsumoHarina = SucursalInsumo.builder()
					.stock_minimo(10)
					.stock_maximo(100)
					.sucursal(sucursalGuaymallen)
					.build();
			sucursalGuaymallenInsumoHarina.setInsumo(harina);
			sucursalInsumoRepository.save(sucursalGuaymallenInsumoHarina);

			SucursalInsumo sucursalGuaymallenInsumoJamon = SucursalInsumo.builder()
					.stock_minimo(102)
					.stock_maximo(1002)
					.sucursal(sucursalGuaymallen)
					.build();
			sucursalGuaymallenInsumoJamon.setInsumo(jamon);
			sucursalInsumoRepository.save(sucursalGuaymallenInsumoJamon);

			SucursalInsumo sucursalGuaymallenInsumoMorrones = SucursalInsumo.builder()
					.stock_minimo(10)
					.stock_maximo(100)
					.sucursal(sucursalGuaymallen)
					.build();
			sucursalGuaymallenInsumoMorrones.setInsumo(morrones);
			sucursalInsumoRepository.save(sucursalGuaymallenInsumoMorrones);

			SucursalInsumo sucursalGuaymallenInsumoCerveza = SucursalInsumo.builder()
					.stock_minimo(10)
					.stock_maximo(100)
					.sucursal(sucursalGuaymallen)
					.build();
			sucursalGuaymallenInsumoCerveza.setInsumo(cerveza);
			sucursalInsumoRepository.save(sucursalGuaymallenInsumoCerveza);

			SucursalInsumo sucursalGuaymallenInsumoFernet = SucursalInsumo.builder()
					.stock_minimo(10)
					.stock_maximo(100)
					.sucursal(sucursalGuaymallen)
					.build();
			sucursalGuaymallenInsumoFernet.setInsumo(fernet);
			sucursalInsumoRepository.save(sucursalGuaymallenInsumoFernet);

			SucursalInsumo sucursalGuaymallenInsumoMenta = SucursalInsumo.builder()
					.stock_minimo(10)
					.stock_maximo(100)
					.sucursal(sucursalGuaymallen)
					.build();
			sucursalGuaymallenInsumoMenta.setInsumo(menta);
			sucursalInsumoRepository.save(sucursalGuaymallenInsumoMenta);

			logger.info("---------------agregue stock insumos--------------------");

			StockInsumo stockInsumoCoca = StockInsumo.builder()
					.cantidad(100)
					.fecha(LocalDate.now())
					.sucursalInsumo(sucursalGuaymallenInsumoCoca)
					.build();
			stockInsumoRepository.save(stockInsumoCoca);

			StockInsumo stockInsumoPepsi = StockInsumo.builder()
					.cantidad(50)
					.fecha(LocalDate.now())
					.sucursalInsumo(sucursalGuaymallenInsumoPepsi)
					.build();
			stockInsumoRepository.save(stockInsumoPepsi);

			StockInsumo stockInsumoHarina = StockInsumo.builder()
					.cantidad(100)
					.fecha(LocalDate.now())
					.sucursalInsumo(sucursalGuaymallenInsumoHarina)
					.build();
			stockInsumoRepository.save(stockInsumoHarina);

			StockInsumo stockInsumoJamon = StockInsumo.builder()
					.cantidad(502)
					.fecha(LocalDate.now())
					.sucursalInsumo(sucursalGuaymallenInsumoJamon)
					.build();
			stockInsumoRepository.save(stockInsumoJamon);

			StockInsumo stockInsumoMorrones = StockInsumo.builder()
					.cantidad(100)
					.fecha(LocalDate.now())
					.sucursalInsumo(sucursalGuaymallenInsumoMorrones)
					.build();
			stockInsumoRepository.save(stockInsumoMorrones);

			StockInsumo stockInsumoCerveza = StockInsumo.builder()
					.cantidad(100)
					.fecha(LocalDate.now())
					.sucursalInsumo(sucursalGuaymallenInsumoCerveza)
					.build();
			stockInsumoRepository.save(stockInsumoCerveza);

			StockInsumo stockInsumoFernet = StockInsumo.builder()
					.cantidad(90)
					.fecha(LocalDate.now())
					.sucursalInsumo(sucursalGuaymallenInsumoFernet)
					.build();
			stockInsumoRepository.save(stockInsumoFernet);

			StockInsumo stockInsumoMenta = StockInsumo.builder()
					.cantidad(100)
					.fecha(LocalDate.now())
					.sucursalInsumo(sucursalGuaymallenInsumoMenta)
					.build();
			stockInsumoRepository.save(stockInsumoMenta);

			logger.info("---------------agregue manufacturados a sucursales--------------------");

			// Crear productos manufacturados
			ArticuloManufacturado pizzaNapolitana = ArticuloManufacturado.builder()
					.denominacion("Pizza Napolitana")
					.unidadMedida(unidadMedidaUnidad)
					.descripcion("pizza rica de queso")
					.preparacion("muzzarela en el horno 10 min")
					.tiempo_estimado_preparacion("20 minutos")
					.build();
			articuloManufacturadoRepository.save(pizzaNapolitana);

			ArticuloManufacturado hamburguesa = ArticuloManufacturado.builder()
					.denominacion("Hamburguesa completa")
					.unidadMedida(unidadMedidaUnidad)
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

			logger.info("---------------agregue manufacturados a sucursales--------------------");

			SucursalManufacturado sucursalGuaymallenManufacturadoPizzaNapolitana = SucursalManufacturado.builder()
					.manufacturado(pizzaNapolitana)
					.sucursal(sucursalGuaymallen)
					.build();
			sucursalManufacturadoRepository.save(sucursalGuaymallenManufacturadoPizzaNapolitana);

			SucursalManufacturado sucursalGuaymallenManufacturadoHamburguesa = SucursalManufacturado.builder()
					.manufacturado(hamburguesa)
					.sucursal(sucursalGuaymallen)
					.build();
			sucursalManufacturadoRepository.save(sucursalGuaymallenManufacturadoHamburguesa);


			logger.info("----------------------creando Roles----------------------------------");
			Rol admin = Rol.builder()
					.nombre("ADMIN")
					.build();
			rolRepository.save(admin);

			Rol clienteUsuario = Rol.builder()
					.nombre("CLIENTE")
					.build();
			rolRepository.save(clienteUsuario);

			Rol cocinero = Rol.builder()
					.nombre("COCINERO")
					.build();
			rolRepository.save(cocinero);

			Rol cajero = Rol.builder()
					.nombre("CAJERO")
					.build();
			rolRepository.save(cajero);

			Rol delivery = Rol.builder()
					.nombre("DELIVERY")
					.build();
			rolRepository.save(delivery);

			logger.info("----------------------creando clientes----------------------------------");
			Usuario usuario = Usuario.builder()
					.auth0id("auth0id")
					.username("NombreUsuario")
					.email("correo@example.com")
					.rol(clienteUsuario)
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
					.rol(cajero) // Asignar el rol de empleado al usuario 1
					.build();
			Usuario usuarioEmpleado2 = Usuario.builder()
					.auth0id("auth0idEmpleado2")
					.username("empleado2")
					.email("empleado2@example.com")
					.rol(cocinero)
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

			logger.info("----------------------creando Empleado Historial Sucursal----------------------------------");


            HistorialEmpleadoSucursal empleadoHistorialSucursal1 = HistorialEmpleadoSucursal.builder()
					.fecha(LocalDate.now())
					.empleado(empleado1)
					.rol(cocinero)
					.sucursal(sucursalMarDelPlata)
					.build();
            historialEmpleadoSucursalRepository.save(empleadoHistorialSucursal1);

			HistorialEmpleadoSucursal empleadoHistorialSucursal2 = HistorialEmpleadoSucursal.builder()
					.fecha(LocalDate.now())
					.empleado(empleado2)
					.rol(cajero)
					.sucursal(sucursalGuaymallen)
					.build();
			historialEmpleadoSucursalRepository.save(empleadoHistorialSucursal2);

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

			logger.info("----------------------creando Estados Pedidos----------------------------------");

			Estado preparacion = Estado.builder()
					.nombre("PREPARACION")
					.build();
			estadoRepository.save(preparacion);

			Estado pendiente = Estado.builder()
					.nombre("PENDIENTE")
					.build();
			estadoRepository.save(pendiente);

			Estado cancelado = Estado.builder()
					.nombre("CANCELADO")
					.build();
			estadoRepository.save(cancelado);

			Estado rechazado = Estado.builder()
					.nombre("RECHAZADO")
					.build();
			estadoRepository.save(rechazado);

			Estado entregado = Estado.builder()
					.nombre("ENTREGADO")
					.build();
			estadoRepository.save(entregado);

			logger.info("----------------------creando Tipo Envios----------------------------------");


			TipoEnvio deliveryEnvio = TipoEnvio.builder()
					.nombre("DELIVERY")
					.build();
			tipoEnvioRepository.save(deliveryEnvio);

			TipoEnvio takeAway = TipoEnvio.builder()
					.nombre("TAKE_AWAY")
					.build();
			tipoEnvioRepository.save(takeAway);

			logger.info("----------------------creando Formas de Pago----------------------------------");

			FormaPago efectivo = FormaPago.builder()
					.nombre("EFECTIVO")
					.build();
			formaPagoRepository.save(efectivo);

			FormaPago mercadoPago = FormaPago.builder()
					.nombre("MERCADO PAGO")
					.build();
			formaPagoRepository.save(mercadoPago);

			logger.info("----------------------creando Pedido----------------------------------");
			Pedido pedido = Pedido.builder()
					.hora_estimada_finalizacion(LocalDateTime.now().plusHours(1))
					.fecha_pedido(LocalDate.now())
					.clienteDomicilio(clienteDomicilio)
					.sucursal(sucursalGuaymallen)
					.empleado(empleado1)
					.formaPago(mercadoPago)
					.tipoEnvio(deliveryEnvio)
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
					.estado(entregado)
					.build();
			pedidoEstadoRepository.save(estadoInicial);
		};
	}
}

