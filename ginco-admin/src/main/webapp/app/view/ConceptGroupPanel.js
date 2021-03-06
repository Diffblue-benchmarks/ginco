/**
 * Copyright or © or Copr. Ministère Français chargé de la Culture
 * et de la Communication (2013)
 * <p/>
 * contact.gincoculture_at_gouv.fr
 * <p/>
 * This software is a computer program whose purpose is to provide a thesaurus
 * management solution.
 * <p/>
 * This software is governed by the CeCILL license under French law and
 * abiding by the rules of distribution of free software. You can use,
 * modify and/ or redistribute the software under the terms of the CeCILL
 * license as circulated by CEA, CNRS and INRIA at the following URL
 * "http://www.cecill.info".
 * <p/>
 * As a counterpart to the access to the source code and rights to copy,
 * modify and redistribute granted by the license, users are provided only
 * with a limited warranty and the software's author, the holder of the
 * economic rights, and the successive licensors have only limited liability.
 * <p/>
 * In this respect, the user's attention is drawn to the risks associated
 * with loading, using, modifying and/or developing or reproducing the
 * software by the user in light of its specific status of free software,
 * that may mean that it is complicated to manipulate, and that also
 * therefore means that it is reserved for developers and experienced
 * professionals having in-depth computer knowledge. Users are therefore
 * encouraged to load and test the software's suitability as regards their
 * requirements in conditions enabling the security of their systemsand/or
 * data to be ensured and, more generally, to use and operate it in the
 * same conditions as regards security.
 * <p/>
 * The fact that you are presently reading this means that you have had
 * knowledge of the CeCILL license and that you accept its terms.
 */
/*
 * File: app/view/ConceptGroupPanel.js
 */

Ext.require([ 'GincoApp.view.MetaDataPanel' ]);

Ext
		.define(
				'GincoApp.view.ConceptGroupPanel',
				{
					extend : 'GincoApp.view.ThesaurusEntityPanel',
					alias : 'widget.conceptGroupPanel',

					localized : true,
					closable : true,
					trackable : true,
					layout : {
						type : 'vbox',
						align : 'stretch'
					},

					// Labels
					xConceptGroupTitle : 'Concept Group',
					xConceptsPanel : 'Concepts',
					xSave : 'Save',
					xDelete : 'Delete',
					xMetadataTitle : 'Metadata',
					xIdentifierLabel : 'Identifier',
					xCreatedLabel : 'Created',
					xModifiedLabel : 'Modified',
					xLabelLabel : 'Group Title',
					xTypeLabel : 'Type',
					xLanguageLabel : 'Language',
					xNotationLabel : 'Notation',
					xConceptGroupFormTitle : 'Concept group',
					xParentGroupLabel : 'Parent group',
					xSelectParentGroup : 'Select a parent group',
					xRemoveParentGroup : 'Remove parent group',
					xParentConceptLabel : 'Parent Concept',
					xSelectParentConcept : 'Select a parent concept',
					xRemoveParentConcept : 'Remove parent concept',
					xActions : 'Actions',
					xLexicalValueLabel : 'Lexical value',
					xAssociationRemove : 'Detach this concept',
					xAddConceptToGroupArray : 'Add a concept',

					initComponent : function() {
						var me = this;

					// This store is used to store the concepts linked to
					// the group
					me.associatedConceptToGroupStore = Ext.create(
							'GincoApp.store.SimpleConceptStore', {
								sorters : [ {
									property : 'label',
									direction : 'asc'
								} ]
							});

						Ext
								.applyIf(
										me,
										{

											title : me.xConceptGroupTitle,
											items : [ {
												xtype : 'form',
												requiredRoles : ['ADMIN', 'MANAGER'],
												title : me.xConceptGroupFormTitle,
												flex : 1,
												autoScroll : true,
												pollForChanges : true,
												trackResetOnLoad : true,
												itemId : 'conceptGroupForm',
												defaults : {
													anchor : '70%'
												},
												bbar : Ext.create('GincoApp.view.BottomFormToolbar'),
												dockedItems : [ {
													xtype : 'toolbar',
													dock : 'top',
													items : [ {
														xtype : 'button',
														requiredRoles : ['ADMIN', 'MANAGER'],
														text : me.xSave,
														disabled : true,
														formBind : true,
														itemId : 'saveConceptGroup',
														cls : 'save',
														iconCls : 'icon-save'
													},
                                                    {
                                                        xtype : 'button',
                                                        requiredRoles : ['ADMIN', 'MANAGER'],
                                                        text : me.xDelete,
                                                        disabled : true,
                                                        cls : 'delete',
                                                        itemId : 'deleteConceptGroupBtn',
                                                        iconCls : 'icon-delete'
                                                    } ]
												} ],
												items : [
												        {
												        	xtype : 'metaDataPanel',
															title : me.xMetadataTitle,
															items : [
																	{
																		xtype : 'displayfield',
																		name : 'identifier',
																		fieldLabel : me.xIdentifierLabel
																	},
																	{
																		xtype : 'displayfield',
																		name : 'created',
																		fieldLabel : me.xCreatedLabel
																	},
																	{
																		xtype : 'displayfield',
																		name : 'modified',
																		fieldLabel : me.xModifiedLabel
																	}
															        ]
												        },
														{
															xtype : 'textfield',
															name : 'label',
															fieldLabel : me.xLabelLabel,
															allowBlank : false,
															padding : '5 0 0 0'
														},
														{
															xtype : 'textfield',
															name : 'thesaurusId',
															hidden : true
														},
														{
															xtype : 'combobox',
															name : 'type',
															fieldLabel : me.xTypeLabel,
															displayField : 'label',
															valueField : 'code',
															editable : false,
															forceSelection : true,
															multiSelect : false,
															allowBlank : false,
														    store : 'ConceptGroupTypeStore'
														},
														{
															xtype : 'combobox',
															name : 'language',
															itemId : 'conceptGroupLanguages',
															fieldLabel : me.xLanguageLabel,
															editable : false,
															displayField : 'refname',
															valueField : 'id',
															forceSelection : true,
															multiSelect : false,
															allowBlank : false,
															store : Ext.create('GincoApp.store.ThesaurusLanguageStore')
														},
														{
															xtype : 'textfield',
															name : 'notation',
															fieldLabel : me.xNotationLabel,
															anchor : '70%'
														},
														{
															xtype : 'hidden',
															name : 'parentGroupId'
														},
														{
															xtype : 'container',
															layout : 'column',
															defaults : {
																margin : '0 0 5 0',
																layout : 'anchor'
															},
															items : [
																	{
																		xtype : 'textfield',
																		name : 'parentGroupLabel',
																		fieldLabel : me.xParentGroupLabel,
																		allowBlank : true,
																		readOnly : true
																	},
																	{
																		xtype : 'button',
																		text : me.xSelectParentGroup,
																		disabled : false,
																		requiredRoles : ['ADMIN', 'MANAGER'],
																		itemId : 'selectParentGroup',
																		cls : 'add',
																		iconCls : 'icon-add'
																	},
																	{
																		xtype : 'button',
																		text : me.xRemoveParentGroup,
																		disabled : true,
																		requiredRoles : ['ADMIN', 'MANAGER'],
																		itemId : 'removeParentGroup',
																		iconCls : 'icon-delete'
																	}]
														},
														{
															xtype : 'panel',
															title : me.xConceptsPanel,
															items : [
																	{
																		xtype : 'hidden',
																		name : 'parentConceptId',
																		hidden : true
																	},
																	{
																		xtype : 'container',
																		itemId : 'parentConceptContainer',
																		hidden : true,
																		layout : 'column',
																		defaults : {
																			margin : '5 0 5 0'
																		},
																		items : [
																				{
																					xtype : 'textfield',
																					name : 'parentConceptLabel',
																					fieldLabel : me.xParentConceptLabel,
																					allowBlank : true,
																					readOnly : true,
																					margin : '1 0 1 0'
																				},
																				{
																					xtype : 'button',
																					text : me.xSelectParentConcept,
																					disabled : false,
																					requiredRoles : ['ADMIN', 'MANAGER'],
																					itemId : 'selectParentConcept',
																					cls : 'add',
																					iconCls : 'icon-add'
																				} ,
																				{
																					xtype : 'button',
																					text : me.xRemoveParentConcept,
																					disabled : true,
																					requiredRoles : ['ADMIN', 'MANAGER'],
																					itemId : 'removeParentConcept',
																					iconCls : 'icon-delete'
																				}]
																	},
																	{
																		xtype : 'gridpanel',
																		itemId : 'gridConceptGroupPanelConcepts',
																		store : me.associatedConceptToGroupStore,
																		hidden : true,
																		border : false,

																		dockedItems : [ {
																			xtype : 'toolbar',
																			dock : 'top',
																			items : [ {
																				xtype : 'button',
																				requiredRoles : ['ADMIN', 'MANAGER'],
																				text : me.xAddConceptToGroupArray,
																				disabled : false,
																				itemId : 'addConceptToGroupArray',
																				cls : 'add',
																				iconCls : 'icon-add'
																			} ]
																		} ],

																		columns : [
																				{
																					dataIndex : 'identifier',
																					text : me.xIdentifierLabel
																				},
																				{
																					dataIndex : 'label',
																					text : me.xLexicalValueLabel,
																					flex : 1
																				},
																				{
																					xtype : 'actioncolumn',
																					itemId : 'conceptToGroupActionColumn',
																					header : me.xActions,
																					items : [ {
																						icon : 'images/detach.png',
																						requiredRoles : ['ADMIN', 'MANAGER'],
																						tooltip : me.xAssociationRemove
																					} ]
																				} ]
																	}
															]

														}]
											} ]
										});

						me.callParent(arguments);
					}

				});