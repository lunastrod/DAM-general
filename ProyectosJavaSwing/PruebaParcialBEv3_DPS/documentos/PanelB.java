	@Override
	public void crearComponentes() {
		// TODO: añadir lo necesario para poder posicionar los componentes con libertad
		
		JLabel lblTitulo = new JLabel("Consultar Ranking");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTitulo.setBounds(44, 33, 225, 22);
		add(lblTitulo);
		
		btnVer = new JButton(AC_BTN_VER);
		btnVer.setBounds(56, 79, 150, 22);
		add(btnVer);
		
		scrpAlbumes = new JScrollPane();
		// TODO: añadir lo necesario para que no se visualice el scrollPane 
		scrpAlbumes.setBounds(56, 132, 620, 320);
		add(scrpAlbumes);
		
		taAlbumes = new JTextArea();
		// TODO: añadir lo necesario para que el textArea no sea editable
		scrpAlbumes.setViewportView(taAlbumes);
		
		btnAnalisis = new JButton(AC_BTN_ANALISIS);
		// TODO: añadir lo necesario para que no se visualice el botón de Realizar Análisis
		btnAnalisis.setBounds(56, 480, 150, 22);
		add(btnAnalisis);

	}